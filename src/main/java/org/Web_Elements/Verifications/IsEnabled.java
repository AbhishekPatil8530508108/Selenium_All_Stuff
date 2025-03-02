package org.Web_Elements.Verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IsEnabled {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("IsEnabled()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_pushbutton_disabled2");
        driver.switchTo().frame(1);
        boolean isEnabled = driver.findElement(By.xpath("//button[text()='My Button']")).isEnabled();
        System.out.println("IsEnabled=" + isEnabled);
        driver.quit();
    }
}
