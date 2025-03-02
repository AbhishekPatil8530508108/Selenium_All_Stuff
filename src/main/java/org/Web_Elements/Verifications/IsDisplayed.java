package org.Web_Elements.Verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IsDisplayed {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("IsDisplayed()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.browserstack.com/");
        boolean isdisplay = driver.findElement(By.id("signupModalProductButton")).isDisplayed();
        System.out.println("IsDisplayed=" + isdisplay);
        driver.quit();
    }
}
