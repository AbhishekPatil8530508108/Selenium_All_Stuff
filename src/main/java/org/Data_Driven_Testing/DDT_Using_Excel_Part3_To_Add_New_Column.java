package org.Data_Driven_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DDT_Using_Excel_Part3_To_Add_New_Column {
    public static void main(String[] args) throws IOException {
        System.out.println("Data Driven Testing To Add New Column In Excel");
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_register_form");
        driver.switchTo().frame(1);

        Xls_Reader reader = new Xls_Reader("D:\\WORKSPACES\\intellij-idea-workspace\\Selenium_All_Stuff\\TextDataFromExcel\\RegistrationExcel.xlsx");
        int rowCount = reader.getRowCount("Sheet1");
//        Insert New Column
        reader.addColumn("Sheet1", "Status");

        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {

            System.out.println("<===========================>");

            String email = reader.getCellData("Sheet1", "Email", rowNum);
            System.out.println(email);
            String password = reader.getCellData("Sheet1", "Password", rowNum);
            System.out.println(password);
            String repeatPassword = reader.getCellData("Sheet1", "Repeat Password", rowNum);
            System.out.println(repeatPassword);

            driver.findElement(By.xpath("//input[contains(@id, 'email')]")).clear();
            driver.findElement(By.xpath("//input[contains(@id, 'email')]")).sendKeys(email);

            driver.findElement(By.xpath("//input[contains(@id, 'psw')]")).clear();
            driver.findElement(By.xpath("//input[contains(@id, 'psw')]")).sendKeys(password);

            driver.findElement(By.xpath("//input[contains(@id, 'psw-repeat')]")).clear();
            driver.findElement(By.xpath("//input[contains(@id, 'psw-repeat')]")).sendKeys(repeatPassword);
//Write The Data Into Cell
            reader.setCellData("Sheet1", "Status", rowNum, "Pass");
        }
    }
}
