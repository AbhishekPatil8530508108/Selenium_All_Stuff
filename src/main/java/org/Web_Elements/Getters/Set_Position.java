package org.Web_Elements.Getters;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Set_Position {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Set Position");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");
        Thread.sleep(5000);
        Point p = new Point(250, 300);
        driver.manage().window().setPosition(p);
        Thread.sleep(5000);
        driver.quit();
    }
}
