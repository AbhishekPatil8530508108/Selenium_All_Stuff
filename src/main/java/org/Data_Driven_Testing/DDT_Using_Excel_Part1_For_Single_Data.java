package org.Data_Driven_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DDT_Using_Excel_Part1_For_Single_Data {
    public static void main(String[] args) throws IOException {
        System.out.println("Data Driven Testing Using Excel Single Data");

        WebDriver driver = WebDriverManager.chromedriver().create();

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_register_form");
        driver.switchTo().frame(1);
        Xls_Reader reader = new Xls_Reader("D:\\WORKSPACES\\intellij-idea-workspace\\Selenium_All_Stuff\\TextDataFromExcel\\RegistrationExcel.xlsx");
//First Row
        String email = reader.getCellData("Sheet1", "Email", 2);
        System.out.println(email);
        String password = reader.getCellData("Sheet1", "Password", 2);
        System.out.println(password);
        String repeatPassword = reader.getCellData("Sheet1", "Repeat Password", 2);
        System.out.println(repeatPassword);
//Now Enter the Data In Form

        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@id='psw']")).sendKeys(password);
        driver.findElement(By.xpath("//input[@id='psw-repeat']")).sendKeys(repeatPassword);
    }

}
