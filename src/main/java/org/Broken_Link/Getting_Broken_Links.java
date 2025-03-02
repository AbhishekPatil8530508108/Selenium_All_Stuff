package org.Broken_Link;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Getting_Broken_Links {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Broken Links Checker");

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("http://www.deadlinkcity.com/errorlist.asp");

        // Correct way to get all anchor tags
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Total Links = " + links.size());

        int noOfBrokenLinks = 0;

        for (WebElement link : links) {
            String hrefVal = link.getAttribute("href");

            if (hrefVal == null || hrefVal.isEmpty()) {
                System.out.println("href value is null or empty, skipping...");
                continue;
            }

            try {
                URL linkUrl = new URL(hrefVal);
                HttpURLConnection conn = (HttpURLConnection) linkUrl.openConnection();
                conn.setRequestMethod("HEAD");
                conn.connect();

                if (conn.getResponseCode() >= 400) {
                    System.out.println(hrefVal + " ==> Broken link");
                    noOfBrokenLinks++;
                } else {
                    System.out.println(hrefVal + " ==> Not a broken link");
                }

            } catch (Exception e) {
                System.out.println("Exception while checking link: " + hrefVal);
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Total Broken Links = " + noOfBrokenLinks);
        driver.quit();
    }
}