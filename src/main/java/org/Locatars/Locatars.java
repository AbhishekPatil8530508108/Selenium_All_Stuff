package org.Locatars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Locatars {
    public static void main(String[] args) {
        System.out.println("Hello Locators");
        WebDriver driver = new ChromeDriver();

        driver.get("https://dribbble.com/session/new");
//       1. XPATH
        driver.findElement(By.xpath("//input[@id='login']")).sendKeys("abhishekrpatil.arp@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Abhishek@1008");
//       2.ID
        driver.findElement(By.id("login")).sendKeys("abhishekrpatil.arp@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Abhishek@1008");
//        3.NAME
        driver.findElement(By.name("login")).sendKeys("abhishekrpatil.arp@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Abhishek@1008");
//        4.LINK TEXT
        driver.findElement(By.linkText("Sign up")).click();
//        5.PARTIAL LINK TEST
        driver.findElement(By.partialLinkText("For")).click();
//        6.CSS SELECTORS
        driver.findElement(By.cssSelector("#password")).sendKeys("Abhishek@1008");
//        7.CLASS NAME
        driver.findElement(By.className("text-input")).sendKeys("abhishekrpatil.arp@gmail.com");
        driver.quit();
    }


}
