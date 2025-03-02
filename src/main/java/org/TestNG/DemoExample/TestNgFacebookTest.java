package org.TestNG.DemoExample;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class TestNgFacebookTest {

    WebDriver driver;

    @Test(priority = 1)
    void openapp() {
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://www.facebook.com/login/");
    }

    @Test(priority = 2)
    void testLogo() {
        boolean status = driver.findElement(By.xpath("//img[contains(@class,'_97vu img')]")).isDisplayed();
        System.out.println("Logo Displayed=" + status);
    }

    @Test(priority = 3)
    void testLogin() {
        driver.findElement(By.xpath("//input[contains(@id,'email')]")).sendKeys("abhishek@gmail.com");
        driver.findElement(By.xpath("//div[@class='clearfix _5466 _44mg']//ancestor::div[contains(@class,'_55r1 _1kbt')]/input[@id='pass']")).sendKeys("Abhi@1008");
        driver.findElement(By.xpath("//button[@id='loginbutton']")).click();
    }

    @Test(priority = 4)
    void testLogout() {
        driver.close();
    }
}
