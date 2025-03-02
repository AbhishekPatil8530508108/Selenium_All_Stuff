package org.Frame_Handling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Switch_To_Frame {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Switch To Frame");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_alert");
        driver.manage().window().maximize();
        driver.switchTo().frame("iframeResult");
        driver.findElement(By.xpath("/html/body/button")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        driver.quit();
    }
}
