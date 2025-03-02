package org.Window_Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FullScreen {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Full Screen");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().fullscreen();
        Thread.sleep(5000);
        driver.quit();
    }
}
