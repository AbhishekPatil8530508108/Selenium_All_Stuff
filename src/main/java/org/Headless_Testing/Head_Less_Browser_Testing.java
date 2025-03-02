package org.Headless_Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class Head_Less_Browser_Testing {
    public static void main(String[] args) {
        System.out.println("Head Less Browser Testing");
//        HEADLESS BROWSER TESTING
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");

//        WE CAN TEST APPLICATION WITHOUT GOING TO BROWSER USING "HtmlUnitDriver"
        WebDriver driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.facebook.com/");
        System.out.println("Before Login=" + driver.getTitle());
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abhishek@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("Abhi@1008");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        System.out.println("After Login=" + driver.getTitle());
        driver.quit();
    }
}
