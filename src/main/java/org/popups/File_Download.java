package org.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class File_Download {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("File Download");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://demo.automationtesting.in/FileDownload.html");
        driver.findElement(By.id("textbox")).sendKeys("Abhishek R Patil");
        driver.findElement(By.id("createTxt")).click();
        driver.findElement(By.id("link-to-download")).click();
        System.out.println("File download has been triggered successfully.");
        driver.quit();
    }
}
