package org.Web_Elements.Getters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class GetText {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("GetText()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.browserstack.com/");
        System.out.println("URL=" + driver.getCurrentUrl());
        WebElement text = driver.findElement(By.xpath("//a[text()='Get started free']"));
        System.out.println("Text=" + text.getText());
        driver.quit();
    }
}
