package org.Data_Driven_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DDT_Write_WebTable_Values_Into_Excel {
    public static void main(String[] args) throws IOException {
        System.out.println("Data Driven Testing To Add WebTales Data In Excel");
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/html/html_tables.asp");

        // Finding all rows (including header row)
        List<WebElement> rowList = driver.findElements(By.xpath("//table[@id='customers']//tr"));
        int rowCount = rowList.size();
//        To Add WebTable Data Into Excel
        Xls_Reader reader = new Xls_Reader("D:\\WORKSPACES\\intellij-idea-workspace\\Selenium_All_Stuff\\TextDataFromExcel\\WebTable Exported Data.xlsx");
        reader.addColumn("Sheet1", "Company");
        reader.addColumn("Sheet1", "Contact");
        reader.addColumn("Sheet1", "Country");
        for (int i = 2; i <= rowCount; i++) {
            String company = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[" + i + "]/td[1]")).getText();
            reader.setCellData("Sheet1", "Company", i, company);
            String contact = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[" + i + "]/td[2]")).getText();
            reader.setCellData("Sheet1", "Contact", i, contact);
            String country = driver.findElement(By.xpath("//table[@id='customers']//tbody/tr[" + i + "]/td[3]")).getText();
            reader.setCellData("Sheet1", "Country", i, country);
        }
        System.out.println("Data Added To Excel Successfully");
    }
}
