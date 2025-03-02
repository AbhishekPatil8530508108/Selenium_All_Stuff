package org.popups;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Hidden_Division_PopUp {
    public static void main(String[] args) {
        System.out.println("Hidden Division PopUp");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        try {
            driver.get("https://www.busonlineticket.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Click "Bus"
            WebElement busOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='booking-search-wrapper']//ancestor::ul[@class='nav nav-tabs d-flex custom-nav-home b-none']/li[@class='flex-grow-1 tab-train']")));
            busOption.click();

            // Click Calendar Icon
            WebElement calendarIcon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='txtDepartDate']")));
            calendarIcon.click();

            // Select Date "12"
            WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='28']")));
            dateElement.click();
            Thread.sleep(5000);

            System.out.println("Date selected successfully!");
        } catch (ElementClickInterceptedException | InterruptedException e) {
            System.out.println("Intercepted Exception: Trying alternative click");
        } finally {
            driver.quit();
        }
    }
}
