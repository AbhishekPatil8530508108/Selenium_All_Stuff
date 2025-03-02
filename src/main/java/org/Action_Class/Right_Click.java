package org.Action_Class;

import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class Right_Click {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Right Click");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
        Actions action = new Actions(driver);
        WebElement rightClick = driver.findElement(By.xpath("//span[text()='right click me']"));
        action.contextClick(rightClick).perform();
        WebElement selectOption = driver.findElement(By.xpath("//span[text()='Quit']"));
        selectOption.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        driver.quit();
    }
}
