package org.Waiting_Statements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Explicit_Wait {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Explicit Wait");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.amazon.in/");
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.xpath("//a[contains(text(),'MX Player')]")).click();
        w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Movies')]")));
        driver.findElement(By.xpath("//span[contains(text(),'Movies')]")).click();
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(5000);
        driver.quit();
    }
}
