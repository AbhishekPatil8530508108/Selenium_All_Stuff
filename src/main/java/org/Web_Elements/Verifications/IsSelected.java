package org.Web_Elements.Verifications;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class IsSelected {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("IsSelected()");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_form_radio");
        driver.switchTo().frame(1);
//  Before Selected
        WebElement isselected = driver.findElement(By.xpath("//input[@id='css']"));
        boolean selected = isselected.isSelected();
        System.out.println("Before Selected=" + selected);
        Thread.sleep(3000);
//  After Selected
        isselected.click();
        boolean select = isselected.isSelected();
        System.out.println("Arter Selected=" + select);
        Thread.sleep(3000);
        driver.quit();
    }
}
