package org.Launch_Chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Third_Way_To_Launch_ChromeBrowser {
    public static void main(String[] args) {
//  Thirs Way to Launch Chrome Browser
        System.out.println("ChromeBrowser Using WebDriverManager.chromedriver().setup();");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        driver.quit();

    }
}
