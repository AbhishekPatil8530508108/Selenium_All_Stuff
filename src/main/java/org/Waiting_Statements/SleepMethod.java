package org.Waiting_Statements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SleepMethod {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Alert");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        Thread.sleep(5000);
        driver.quit();
    }
}
