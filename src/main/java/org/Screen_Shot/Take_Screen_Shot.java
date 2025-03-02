package org.Screen_Shot;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.concurrent.TimeUnit;

public class Take_Screen_Shot {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Navigation API'S");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.amazon.in/");
//      Take ScreenShot and Store As A File Format
        File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//      Now Copy The ScreenShot To Desire Location Using CopyFile/Method
        Files.copy(f.toPath(), new File("D:\\WORKSPACES\\intellij-idea-workspace\\Selenium_All_Stuff\\ScreenShot\\amazon.png").toPath());
        driver.quit();
    }
}
