package org.Launch_Chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Second_Way_To_Launch_ChromeBrowser {

    public static void main(String[] args) {
        System.out.println("ChromeBrowser Using WebDriver driver=new ChromeDriver();");
//	Second Way To Launch ChromeBrowser
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.co.in/");
        driver.quit();

    }

}
