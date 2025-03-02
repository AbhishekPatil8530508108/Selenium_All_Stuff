package org.Window_Management;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximiseWindow {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Maximise");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        Thread.sleep(5000);
        driver.quit();
    }
}
