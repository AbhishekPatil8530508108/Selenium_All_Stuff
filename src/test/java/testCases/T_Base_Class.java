package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;
public class T_Base_Class {
    public static WebDriver driver;
    public Logger logger;
    public Properties p;

        @BeforeClass(groups = {"Sanity","Regression","Master","Data driven"})

        @Parameters({"os","browser"})

        void setup(String os,String br) throws IOException {
            FileReader file=new FileReader("D:\\WORKSPACES\\intellij-idea-workspace\\Selenium_All_Stuff\\src\\test\\resources\\config.properties");
            p=new Properties();
            p.load(file);
            logger= LogManager.getLogger(this.getClass());
//            REMOTE ENVIRONMENT
            if (p.getProperty("execution_env").equalsIgnoreCase("remote"))
            {
                DesiredCapabilities Capabilities=new DesiredCapabilities();
//          OS
                if (os.equalsIgnoreCase("windows"))
                {
                    Capabilities.setPlatform(Platform.WINDOWS);
                } else if (os.equalsIgnoreCase("linux"))
                {
                    Capabilities.setPlatform(Platform.LINUX);
                }
                else
                {
                    System.out.println("No Matching OS");
                    return;
                }
//          BROWSER
                switch (br.toLowerCase())
                {
                    case "chrome":Capabilities.setBrowserName("chrome");
                    break;
                    case "edge":Capabilities.setBrowserName("MicrosoftEdge");
                    break;
                    case "firefox":Capabilities.setBrowserName("firefox");
                    break;
                    default:
                        System.out.println("No Matching Browser");
                        return;
                }
                driver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),Capabilities);
            }
//            LOCAL ENVIRONMENT
            if (p.getProperty("execution_env").equalsIgnoreCase("local"))
            {
                switch (br.toLowerCase())
                {
                    case "chrome" :driver=new ChromeDriver();
                        break;
                    case "edge" :driver=new EdgeDriver();
                        break;
                    case "firefox" :driver=new FirefoxDriver();
                        break;
                    default:
                        System.out.println("Invalid Browser");
                        return;
                }
            }

            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
            driver.get(p.getProperty("URL1"));
        }
//        To generate Random Email address every time bcz once we register
//        an account we cant use same email again so we use randomString()

        public String randomString(){
            String generatedString= RandomStringUtils.randomAlphabetic(5);
            return generatedString;
        }

//    To generate Random Numbers
//    we use randomNumber()

        public String randomNumber(){
            String generatedNumber=RandomStringUtils.randomNumeric(10);
            return generatedNumber;
        }

//      To generate Random Password every
//    by combining both randomString() And randomNumber()

        public String randomAlphaNumeric(){
            String generatedString=RandomStringUtils.randomAlphabetic(3);
            String generatedNumber=RandomStringUtils.randomNumeric(10);
            return (generatedString+"@"+generatedNumber);
        }

        @AfterClass(groups = {"Sanity","Regression","Master","Data driven"})
        public void tearDown(){
            driver.quit();
        }
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile = new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;
    }

}
