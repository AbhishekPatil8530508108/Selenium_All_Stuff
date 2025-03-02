package org.DropDown;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class Select_By {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Select By DropDown");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.globalsqa.com/demo-site/select-dropdown-menu/#google_vignette");
        Select select = new Select(driver.findElement(By.xpath("//*[@id=\"post-2646\"]/div[2]/div/div/div/p/select")));
        select.selectByVisibleText("Argentina");
        select.selectByIndex(2);
        select.selectByValue("ASM");
        List<WebElement> list = new ArrayList<>(select.getOptions());
        System.out.println(list.size());
//        Getting All Elements By DropDown
        for (int i = 0; i < list.size(); i++) {
            String list1 = list.get(i).getText();
            System.out.println(list1);
        }
        driver.quit();
    }
}
