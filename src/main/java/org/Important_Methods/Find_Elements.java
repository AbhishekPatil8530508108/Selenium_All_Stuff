package org.Important_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Find_Elements {
    public static void main(String[] args) {
        System.out.println("Find Elements");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.amazon.in/");
//  1. Get the total count of links on the page
        List<WebElement> linkedlist = driver.findElements(By.tagName("a"));//LINKS
        System.out.println("LINKS=" + linkedlist.size());
        List<WebElement> linkedlist1 = driver.findElements(By.tagName("input"));//INPUTS
        System.out.println("INPUT FIELDS=" + linkedlist1.size());
        List<WebElement> linkedlist2 = driver.findElements(By.tagName("button"));//BUTTONS
        System.out.println("BUTTONS=" + linkedlist2.size());
//  2. Get the text of each link on the page
        for (int i = 0; i < linkedlist.size(); i++) {
            String list = linkedlist.get(i).getText();
            System.out.println(list);
        }
        driver.quit();

    }
}
