package org.Web_Elements.Getters;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Get_Page_Source {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Get Page Source()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.google.com");
        String source = driver.getPageSource();
        System.out.println("SOURCE=\n" + source);
        driver.quit();
    }
}
