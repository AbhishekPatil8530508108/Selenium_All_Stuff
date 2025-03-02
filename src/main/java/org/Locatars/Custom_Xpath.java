package org.Locatars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Custom_Xpath {
    public static void main(String[] args) {
        System.out.println("Custom Xpath");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.amazon.in/");
//  1stWAY
        driver.findElement(By.xpath("//input[@class='nav-input nav-progressive-attribute']"))
                .sendKeys("Java");
//  2ndWAY
        driver.findElement(By.xpath("//input[@name='field-keywords']"))
                .sendKeys("Java");
//  3rdWAY
        driver.findElement(By.xpath("//input[contains(@class,'nav-input')]"))
                .sendKeys("Java");
//  4thWAY
        driver.findElement(By.xpath("//input[contains(@id,'twotabsearchtextbox')]"))
                .sendKeys("Java");
//  5thWAY
        driver.findElement(By.xpath("//input[starts-with(@id,'twotabsearchtextbox')]"))
                .sendKeys("Java");
//  6thWAY
        driver.findElement(By.xpath("//input[ends-with(@id,'twotabsearchtextbox')]"))
                .sendKeys("Java");
        driver.quit();

    }
}
