package org.Page_Object_Model_POM.Without_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM_Demo_LoginPage {
    WebDriver driver;
//    constructor
public POM_Demo_LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
//    locators
        By txt_username_loc=By.xpath("//input[contains(@id,'email')]");
        By txt_password_loc=By.xpath("//div[@class='clearfix _5466 _44mg']//ancestor::div[contains(@class,'_55r1 _1kbt')]/input[@id='pass']");
        By btn_login_loc=By.xpath("//button[@id='loginbutton']");
//    Action Method
    public void setUserName(String user){
        driver.findElement(txt_username_loc).sendKeys(user);
    }
    public void setPassword(String pwd){
        driver.findElement(txt_password_loc).sendKeys(pwd);
    }
    public void loginClick(){
        driver.findElement(btn_login_loc).click();
    }
}
