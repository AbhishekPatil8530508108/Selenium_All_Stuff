package org.TestNG.Listeners;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.time.Duration;
//If We Don't Have A XML File So We Can Execute Using @Listeners
//@Listeners(Listeners_Demo.class)

public class Listeners_Demo2 {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver=WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/login/");
    }
    @Test(priority = 1)
    void testLogin(){

        boolean status = driver.findElement(By.xpath("//img[contains(@class,'_97vu img')]")).isDisplayed();
        System.out.println("Logo Displayed=" + status);
    }
    @Test(priority = 2,dependsOnMethods ={"testLogin"})
    void testTitle(){
        Assert.assertEquals(driver.getTitle(),"Log in to Face");
    }
    @Test(priority = 3,dependsOnMethods ={"testTitle"})
    void testUrl(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.facebook.com/login/");
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
}
