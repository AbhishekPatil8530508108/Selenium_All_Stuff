package org.Scroll_Bar;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Page_Scroll {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Page Scroll");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://mdbootstrap.com/docs/b4/jquery/tables/scroll/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
//      Scroll Down
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,3050)");

//      Scroll Up
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-2000)");
        Thread.sleep(2000);
        driver.quit();
    }
}
