package org.Web_Elements.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Clear {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Clear()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.flipkart.com/");
        WebElement c = driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        c.sendKeys("iphone 16 pro");
        Thread.sleep(2000);
        c.clear();
        c.sendKeys("iphone 16 pro max");
        Thread.sleep(2000);
        driver.quit();
    }
}
