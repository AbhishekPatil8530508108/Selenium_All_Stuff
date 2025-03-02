package org.Web_Elements.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Click {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Click()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.flipkart.com/");

        driver.findElement(By.xpath("//span[text()='Mobiles']")).click();
        Thread.sleep(3000);
        driver.quit();
    }
}
