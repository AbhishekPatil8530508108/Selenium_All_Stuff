package org.Important_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckBox {
    public static void main(String[] args) {
        System.out.println("CheckBox");
        WebDriver driver = new ChromeDriver();

        driver.get("http://total-qa.com/checkbox-example/");
        driver.findElement(By.cssSelector("#post-3261 > div > p > input[type=checkbox]:nth-child(3)")).click();
        driver.quit();
    }
}
