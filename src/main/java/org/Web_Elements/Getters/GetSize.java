package org.Web_Elements.Getters;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetSize {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("GetSize()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://testkru.com/Elements/TextFields");
        WebElement size = driver.findElement(By.xpath("//input[@id='firstName']/ancestor::div[@class='mt-2 row text-dark font-weight-bold']"));
        Dimension s = size.getSize();
        System.out.println("Height=" + s.getHeight());
        System.out.println("Width=" + s.getWidth());
        driver.quit();
    }
}
