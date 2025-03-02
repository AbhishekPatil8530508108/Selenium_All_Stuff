package org.Data_Reading_From_Properties_File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Read_PropretyFile {
    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException, IOException {
        Properties pro = new Properties();
//        SET PROPERTY PATH
        FileInputStream file = new FileInputStream("D:\\WORKSPACES\\intellij-idea-workspace\\Selenium_All_Stuff\\src\\main\\java\\org\\Data_Reading_From_Properties_File\\config.porperties");
        pro.load(file);
//        GET VALUES FROM PROPERTY
        System.out.println(pro.getProperty("name"));
        System.out.println(pro.getProperty("age"));
//        GET URL FROM PROPERTY FILE
        String url = pro.getProperty("url");
        System.out.println(url);
//        GET BROWSER FROM PROPERTY FILE
        String browser = pro.getProperty("browser");
        System.out.println(browser);
//         TO LAUNCH BROWSER USING PROPERTY FILE
        if (browser.equals("chrome")) {
            System.out.println("Read Property()");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else {
            System.out.println("Chrome is not found");
        }

        driver.get(url);
        driver.findElement(By.xpath(pro.getProperty("Email.xpath"))).sendKeys(pro.getProperty("Email"));
        driver.findElement(By.xpath(pro.getProperty("Password.xpath"))).sendKeys(pro.getProperty("Password"));
        driver.quit();
    }
}
