package org.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Deselect_By {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Deselect By DropDown");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://grotechminds.com/multiple-select/");
        Select s = new Select(driver.findElement(By.id("automobiles")));
        s.selectByVisibleText("Hatchback");
        s.selectByValue("sedan");
        s.selectByIndex(3);
//Deselect
        s.deselectByVisibleText("Hatchback");
        s.deselectByValue("sedan");
        s.selectByIndex(3);
//       OR
        s.deselectAll();
//        Get Elements
        List<WebElement> list = s.getOptions();
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            String list1 = list.get(i).getText();
            System.out.println(list1);
        }
        driver.quit();
    }
}
