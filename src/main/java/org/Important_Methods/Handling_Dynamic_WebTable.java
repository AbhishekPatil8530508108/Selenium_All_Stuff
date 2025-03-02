package org.Important_Methods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Handling_Dynamic_WebTable {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Handling Dynamic WebTable");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/html/html_tables.asp");
//     ROW
        List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        int rowCount = rowList.size();
        System.out.println("Total Rows: " + rowCount);
//  COLUMN
        List<WebElement> columnList = driver.findElements(By.xpath("//table[@id='customers']//tr[1]/th"));
        int columnCount = columnList.size();
        System.out.println("Total Columns: " + columnCount);
//  SPECIFIC ROW & COLUMN
        WebElement rowcol = driver.findElement(By.xpath("//table[@id='customers']/tbody/tr[3]/td[3]"));
        System.out.println("Row 3, Column 3 Data: " + rowcol.getText());
//  To Print Entire Table

        for (int i = 2; i <= rowCount; i++) {
            String company = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[" + i + "]/td[1]")).getText();
            String contact = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[" + i + "]/td[2]")).getText();
            String country = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[" + i + "]/td[3]")).getText();

            System.out.println("Row " + (i - 1) + ": " + company + " | " + contact + " | " + country);
        }
        driver.quit();
    }
}