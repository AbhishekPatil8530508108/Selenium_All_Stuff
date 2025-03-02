package org.Web_Elements.Getters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Get_Position {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Get Position()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
        System.out.println("Position+" + driver.manage().window().getPosition());
        driver.quit();
    }
}
