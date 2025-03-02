package org.Data_Driven_Testing;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class DDT_To_Check_Result_Pass_Or_Fail {
    public static void main(String[] args) throws IOException {
        System.out.println("Data Driven Testing To Check Result Pass Or Fail");
        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://exrx.net/Calculators/SimpleCalculator");

        Xls_Reader reader = new Xls_Reader("D:\\WORKSPACES\\intellij-idea-workspace\\Selenium_All_Stuff\\TextDataFromExcel\\CalculatorExcel.xlsx");
        int rowCount = reader.getRowCount("Sheet1");

        for (int i = 2; i <= rowCount; i++) {
            String values = reader.getCellData("Sheet1", "Values", i);
            System.out.println("Input: " + values);
            String expectedResult = reader.getCellData("Sheet1", "Result", i);
            System.out.println("Expected Result: " + expectedResult);

            driver.findElement(By.xpath("//input[contains(@name,'expr')]")).clear();
            driver.findElement(By.xpath("//input[contains(@name,'expr')]")).sendKeys(values);
            driver.findElement(By.xpath("//input[contains(@type,'button')]")).click();

            String actualResult = driver.findElement(By.xpath("//input[contains(@name,'result')]")).getAttribute("value");
            System.out.println("Actual Result: " + actualResult);
            if (actualResult.equals(expectedResult)) {
                System.out.println("Test Passed");
                reader.setCellData("Sheet1", "Test", i, "Pass");
            } else {
                System.out.println("Test Filed");
                reader.setCellData("Sheet1", "Test", i, "Fail");
            }
        }
    }
}
