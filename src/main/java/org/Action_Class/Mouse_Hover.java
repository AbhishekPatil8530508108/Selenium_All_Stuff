package org.Action_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Hover {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Mouse Hover");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://corporate.spicejet.com/SpiceRoute.aspx");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.id("highlight-addons"))).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("You 1st")).click();
        driver.quit();
    }
}
