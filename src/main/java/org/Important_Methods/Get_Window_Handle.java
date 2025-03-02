package org.Important_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Get_Window_Handle {
    public static void main(String[] args) {
        System.out.println("Child Browser PopUp(Get_Window_Handle)");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.google.com");

        // Get the window handle
        String windowHandle = driver.getWindowHandle();

        // Print the window handle
        System.out.println("Current Window Handle: " + windowHandle);

        // Close the browser
        driver.quit();
    }
}
