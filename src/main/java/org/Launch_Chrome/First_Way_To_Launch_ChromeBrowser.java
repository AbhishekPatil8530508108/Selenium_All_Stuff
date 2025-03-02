package org.Launch_Chrome;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class First_Way_To_Launch_ChromeBrowser {

    public static void main(String[] args) {
        System.out.println("ChromeBrowser Using System.SetPririty();" + "\n" + "WebDriver driver=new ChromeDriver();" + "\n" + "OR" + "\n" + "ChromeDriver driver=new ChromeDriver();");
//	First Way To Launch ChromeBrowser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\abhir\\Downloads\\AutomationFiles\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
//		ChromeDriver driver=new ChromeDriver();
        driver.get("https://www.google.co.in/");
    }
}
