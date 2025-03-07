package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Base_Class {

    public Login_Page(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement txtEmailAddress;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;
    @FindBy(xpath = "//input[@class='btn btn-primary']")
    WebElement btnLogin;

    public void setEmail(String email){
        txtEmailAddress.sendKeys(email);
    }
    public void setPassword(String pwd){
        txtPassword.sendKeys(pwd);
    }
    public void clickLogin(){
        btnLogin.click();
    }
}
