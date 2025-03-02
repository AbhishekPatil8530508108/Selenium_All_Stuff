package org.TestNG.Parallel_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class Parallel_Testing_Using_XML {
    WebDriver driver;
    @BeforeClass
    @Parameters({"browser"})
    void setup(String br){
        switch (br.toLowerCase())
        {
            case "chrome" :driver= WebDriverManager.chromedriver().create();
                break;
            case "edge" :driver= WebDriverManager.edgedriver().create();
                break;
            case "firefox" :driver= WebDriverManager.firefoxdriver().create();
            break;
            default:
                System.out.println("Invalid Browser");
                return;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/login/");
    }
    @Test(priority = 1)
    void testLogin(){

        boolean status = driver.findElement(By.xpath("//img[contains(@class,'_97vu img')]")).isDisplayed();
        System.out.println("Logo Displayed=" + status);
    }
    @Test(priority = 2)
    void testTitle(){
        Assert.assertEquals(driver.getTitle(),"Log in to Facebook");
    }
    @Test(priority = 3)
    void testUrl(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/login/");
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
