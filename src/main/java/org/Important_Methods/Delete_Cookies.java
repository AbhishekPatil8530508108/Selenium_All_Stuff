package org.Important_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Delete_Cookies {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Cookies Deleted");
        WebDriver driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.get("https://www.google.com");
        driver.quit();
    }
}
