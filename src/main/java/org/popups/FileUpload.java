package org.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("File Upload ");
        WebDriver driver = new ChromeDriver();

        driver.get("https://html.com/input-type-file/");
        driver.findElement(By.xpath("//*[@id=\"fileupload\"]")).sendKeys("C:\\Users\\abhir\\Downloads\\GouriLakade.jpeg");
        Thread.sleep(5000);
        driver.quit();
    }
}
