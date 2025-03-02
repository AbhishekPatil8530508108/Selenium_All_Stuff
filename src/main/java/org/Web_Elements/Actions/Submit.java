package org.Web_Elements.Actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Submit {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Submit()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.instagram.com/accounts/login/?hl=en");
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Abhishek@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("Abhi@1008");
        WebElement sub = driver.findElement(By.xpath("//div[text()='Log in']"));
        sub.submit();
        Thread.sleep(2000);
        driver.quit();

    }
}
