package org.TestNG.Listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners_Demo implements ITestListener {
    public void onStart(ITestContext context) {
        System.out.println("  Execution Start");
    }
    public void onTestStart(ITestResult result) {
        System.out.println("  Test Start");
    }
    public void onTestSuccess(ITestResult result) {
        System.out.println("  Test Success");
    }
    public void onTestFailure(ITestResult result) {
        System.out.println("  Test Fail");
    }
    public void onTestSkipped(ITestResult result) {
        System.out.println("  Test Skip");
    }
    public void onFinish(ITestContext context) {
        System.out.println("  Execution Finish");
    }
}
