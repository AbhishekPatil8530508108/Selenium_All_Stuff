package org.Page_Object_Model_POM.Without_PageFactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class POM_Demo_LoginTest {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver= WebDriverManager.chromiumdriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/login/");
    }
    @Test
    void testLogin(){
        POM_Demo_LoginPage lp=new POM_Demo_LoginPage(driver);
        lp.setUserName("abhishek@gmail.com");
        lp.setPassword("Abhi@1008");
        lp.loginClick();
        Assert.assertEquals(driver.getTitle(),"Log in to Facebook");
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }

}
