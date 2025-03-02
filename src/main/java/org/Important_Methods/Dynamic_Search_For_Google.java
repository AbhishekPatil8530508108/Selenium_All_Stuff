package org.Important_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Dynamic_Search_For_Google {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Handling Dynamic Search For Google");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
        driver.findElement(By.id("APjFqb")).sendKeys("Testing");
        driver.findElement(By.xpath("//div[contains(@id,'Alh6id')]//ancestor::ul[@class='G43f7e']//li[@class='sbct PZPZlf']//div[@class='eIPGRd']//div[@class='pcTkSc']//b[text()=' jobs in pune']")).click();
        driver.quit();
    }
}
