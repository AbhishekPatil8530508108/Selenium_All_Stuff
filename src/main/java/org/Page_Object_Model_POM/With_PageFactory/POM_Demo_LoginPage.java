package org.Page_Object_Model_POM.With_PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POM_Demo_LoginPage {
    WebDriver driver;
//    constructor
POM_Demo_LoginPage(WebDriver driver)
    {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
//    locators
       @FindBy(xpath="//input[contains(@id,'email')]")
            WebElement txt_username;
       @FindBy(xpath="//div[@class='clearfix _5466 _44mg']//ancestor::div[contains(@class,'_55r1 _1kbt')]/input[@id='pass']")
            WebElement txt_password;
       @FindBy(xpath="//button[@id='loginbutton']")
            WebElement btn_loginClick;
//    Action Method
    public void setUserName(String user){
        txt_username.sendKeys(user);
    }
    public void setPassword(String pwd){
        txt_password.sendKeys(pwd);
    }
    public void loginClick(){
        btn_loginClick.click();
    }
}
