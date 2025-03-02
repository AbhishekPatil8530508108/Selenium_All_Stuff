package org.Web_Elements.Getters;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetLocation {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("GetLocation()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://testkru.com/Elements/TextFields");
        WebElement location = driver.findElement(By.xpath("//input[@id='firstName']/ancestor::div[@class='mt-2 row text-dark font-weight-bold']"));
        Point loc = location.getLocation();
        System.out.println("X Coordinate=" + loc.getX());
        System.out.println("Y Coordinate=" + loc.getY());
        driver.quit();
    }
}
