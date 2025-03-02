package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testCases.T_Base_Class;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ExtentReportManager implements ITestListener {
    private static ExtentSparkReporter sparkReporter;
    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> threadLocalTest = new ThreadLocal<>();
    private String repName;

    @Override
    public void onStart(ITestContext testContext) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        repName = "Test-Report-" + timeStamp + ".html";

        // Ensure the reports directory exists
        File reportsDir = new File("./reports");
        if (!reportsDir.exists()) {
            reportsDir.mkdirs();
        }

        sparkReporter = new ExtentSparkReporter("./reports/" + repName);
        sparkReporter.config().setDocumentTitle("Opencart Automation Report");
        sparkReporter.config().setReportName("Opencart Functional Testing");
        sparkReporter.config().setTheme(Theme.DARK);

        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);

        extent.setSystemInfo("Application", "Opencart");
        extent.setSystemInfo("Module", "Admin");
        extent.setSystemInfo("Sub Module", "Customers");
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environment", "QA");

        String os = testContext.getCurrentXmlTest().getParameter("os");
        extent.setSystemInfo("Operating System", (os != null) ? os : "Unknown OS");

        String browser = testContext.getCurrentXmlTest().getParameter("browser");
        extent.setSystemInfo("Browser", (browser != null) ? browser : "Unknown Browser");

        List<String> includedGroups = testContext.getCurrentXmlTest().getIncludedGroups();
        extent.setSystemInfo("Groups", includedGroups.isEmpty() ? "None" : includedGroups.toString());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        threadLocalTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        threadLocalTest.get().log(Status.PASS, "Test Case Passed: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTest test = threadLocalTest.get();
        test.log(Status.FAIL, "Test Case Failed: " + result.getName());
        test.log(Status.FAIL, result.getThrowable());

        try {
            String imgPath = new T_Base_Class().captureScreen(result.getName());
            if (imgPath != null) {
                test.addScreenCaptureFromPath(imgPath);
            } else {
                test.log(Status.WARNING, "Screenshot path is null.");
            }
        } catch (IOException e) {
            test.log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        threadLocalTest.get().log(Status.SKIP, "Test Case Skipped: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext testContext) {
        extent.flush();

        String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator + repName;
        File extentReport = new File(reportPath);

        try {
            if (extentReport.exists()) {
                Desktop.getDesktop().browse(extentReport.toURI());
            } else {
                System.out.println("Report file not found: " + reportPath);
            }
        } catch (IOException e) {
            System.err.println("Error opening Extent Report: " + e.getMessage());
        }
    }
}
