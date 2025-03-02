package org.Data_Driven_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DDT_Using_Excel_Part2_For_Multiple_Data {
    public static void main(String[] args) throws IOException {
        System.out.println("Data Driven Testing Using Excel Foe Multiple Data");
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_register_form");
        driver.switchTo().frame(1);
//Read Data From Excel File
        Xls_Reader reader = new Xls_Reader("D:\\WORKSPACES\\intellij-idea-workspace\\Selenium_All_Stuff\\TextDataFromExcel\\RegistrationExcel.xlsx");
        int rowCount = reader.getRowCount("Sheet1");
        for (int rowNum = 2; rowNum <= rowCount; rowNum++) {
//            Each Data In Separate Line
            System.out.println("<===========================>");
//            Traversing Row And Column Data From Loop
            String email = reader.getCellData("Sheet1", "Email", rowNum);
            System.out.println(email);
            String password = reader.getCellData("Sheet1", "Password", rowNum);
            System.out.println(password);
            String repeatPassword = reader.getCellData("Sheet1", "Repeat Password", rowNum);
            System.out.println(repeatPassword);
//Now Enter the Data In Form
//          First Clear The Value
            driver.findElement(By.xpath("//input[contains(@id, 'email')]")).clear();
//          Then Enter The Value
            driver.findElement(By.xpath("//input[contains(@id, 'email')]")).sendKeys(email);
//          First Clear Enter The Value
            driver.findElement(By.xpath("//input[contains(@id, 'psw')]")).clear();
//          Then Enter The Value
            driver.findElement(By.xpath("//input[contains(@id, 'psw')]")).sendKeys(password);
//          First Clear Enter The Value
            driver.findElement(By.xpath("//input[contains(@id, 'psw-repeat')]")).clear();
//          Then Enter The Value
            driver.findElement(By.xpath("//input[contains(@id, 'psw-repeat')]")).sendKeys(repeatPassword);
        }
    }
}
