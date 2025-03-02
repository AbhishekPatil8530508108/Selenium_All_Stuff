package org.Web_Elements.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SendKeys {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Send Keys()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.flipkart.com/");
        driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("iphone 16");
        driver.quit();
    }
}
