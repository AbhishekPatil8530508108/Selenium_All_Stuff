package org.Web_Elements.Getters;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetAttribute {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("GetAttribute()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.geeksforgeeks.org/");
        WebElement attribute = driver.findElement(By.xpath("//input[@class='HomePageSearchContainer_homePageSearchContainer_container_input__1LS0r']"));
        System.out.println("Attribute Val=" + attribute);
        driver.quit();
    }
}
