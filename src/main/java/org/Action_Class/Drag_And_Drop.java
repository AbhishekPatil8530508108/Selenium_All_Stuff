package org.Action_Class;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Drag_And_Drop {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Drag And Drop");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        Actions actions = new Actions(driver);
        actions.clickAndHold(driver.findElement(By.xpath("//*[@id=\"draggable\"]")))
                .moveToElement(driver.findElement(By.xpath("//*[@id=\"droppable\"]")))
                .release()
                .build()
                .perform();
        Thread.sleep(2000);
        driver.quit();

    }
}
