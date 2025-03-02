package org.TestNG.Data_Provider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Data_Provider_Demo_Hard_Coded {
    WebDriver driver;
    @BeforeClass
    void setup(){
        driver=WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test(dataProvider = "loginData")
    void testLogin(String email, String pwd){
        driver.get("https://www.facebook.com/login/");
        driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys(email);
        driver.findElement(By.xpath("//div[@class='clearfix _5466 _44mg']//ancestor::div[contains(@class,'_55r1 _1kbt')]/input[@id='pass']")).sendKeys(pwd);
        driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
        boolean status = driver.findElement(By.xpath("//a[contains(text(),'Log In with Google')]")).isDisplayed();
        System.out.println("Logo Displayed=" + status);
        if (status==true)
        {
            driver.findElement(By.xpath("//a[contains(text(),'Log In with Google')]")).click();
            Assert.assertTrue(true);
        }
        else
        {
            Assert.fail();
        }
    }
    @AfterClass
    void tearDown(){
        driver.quit();
    }
    @DataProvider(name = "loginData",indices = {0,2})
    Object[][] loginData(){
        Object data[][]={
                {"abhishek@gmail.com","Abhi@1008"},
                {"abhi@gmail.com","Abhi@1008"},
                {"aap@gmail.com","Abhi@1008"},
                {"abhirpatil@gmail.com","Abhi@1008"},
                {"abhishekpatil@gmail.com","Abhi@1008"}
        };
        return data;
    }
}
