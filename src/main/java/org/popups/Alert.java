package org.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {
    public static void main(String[] args) {
        System.out.println("Alert");
        WebDriver driver = new ChromeDriver();

        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
        driver.findElement(By.name("proceed")).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();//To go Alert PoPup
        System.out.println("TEXT=" + alert.getText());//To Get Text
        alert.accept();//To click on ok
//        alert.dismiss();//To Cancel If it is Present
        driver.quit();

    }
}
