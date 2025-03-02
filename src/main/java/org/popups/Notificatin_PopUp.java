package org.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Notificatin_PopUp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Notification PopUp");
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        WebDriver diver = new ChromeDriver(option);
        diver.manage().window().maximize();
        diver.get("https://www.justdial.com/");
        Thread.sleep(10000);
        diver.quit();
    }
}
