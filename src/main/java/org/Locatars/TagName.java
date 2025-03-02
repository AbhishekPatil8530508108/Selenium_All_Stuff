package org.Locatars;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TagName {
    public static void main(String[] args) {
        System.out.println("Hello Locators");
        WebDriver driver = new ChromeDriver();

        driver.get("https://dribbble.com/session/new");
//        8.TAG NAME
        WebElement element = driver.findElement(By.tagName("button"));
        System.out.println(element);
        driver.quit();
    }
}