package org.popups;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Child_Browser {
    public static void main(String[] args) throws InterruptedException, IOException {
        System.out.println("Child Browser PopUp");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.get("https://www.rrc.texas.gov/resource-center/research/gis-viewer/gis-popup-blocker-test/");
        driver.findElement(By.xpath("//a[contains(text(),'RUN POPUP TEST')]")).click();

        Thread.sleep(3000);
        Set<String> handles = driver.getWindowHandles();
        Iterator<String> iterator = handles.iterator();

        String parentwondoewId = iterator.next();
        System.out.println("Parent Window Id=" + parentwondoewId);

        String childwindowId = iterator.next();
        System.out.println("Child Window Id=" + childwindowId);

        driver.switchTo().window(childwindowId);
        Thread.sleep(3000);
        System.out.println("Child Window PopUp Title=" + driver.getTitle());

        driver.switchTo().window(parentwondoewId);
        Thread.sleep(3000);
        System.out.println("Parent Window PopUp Title=" + driver.getTitle());
        driver.quit();
    }
}
