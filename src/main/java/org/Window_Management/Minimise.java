package org.Window_Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Minimise {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Minimise");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().minimize();
        Thread.sleep(5000);
        driver.quit();
    }
}
