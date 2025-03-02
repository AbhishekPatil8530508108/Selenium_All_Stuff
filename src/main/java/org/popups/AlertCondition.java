package org.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertCondition {
    public static void main(String[] args) {
        System.out.println("Alert Condition ");
        WebDriver driver = new ChromeDriver();
        driver.get("https://mail.rediff.com/cgi-bin/login.cgi");

        driver.findElement(By.name("proceed")).click();
        org.openqa.selenium.Alert alert = driver.switchTo().alert();//To go Alert PoPup
        System.out.println("TEXT=" + alert.getText());//To Get Text
        String text = alert.getText();
        if (text.equals("Please enter a valid user name")) {
            System.out.println("Correct Alert Msg");
        } else {
            System.out.println("Incorrect Alert Msg");
        }
        alert.accept();//To click on ok
        driver.quit();
    }
}
