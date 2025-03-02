package org.Launch_Chrome;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Fourth_Way_To_Launch_ChromeBrowser {

    public static void main(String[] args) {
        System.out.println("ChromeBrowser Using WebDriverManager.chromedriver().create();");
//	Fourth Way to Launch Chrome Browser
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://www.google.co.in/");
    }

}
