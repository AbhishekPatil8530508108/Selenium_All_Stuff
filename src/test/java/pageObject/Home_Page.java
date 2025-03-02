package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends Base_Class {
//    constructor
    public Home_Page(WebDriver driver) {
        super(driver);
    }
//    locators
    @FindBy(xpath = "//span[contains(text(),'My Account')]")
    WebElement linkMyAccount;
    @FindBy(xpath = "//a[contains(text(),'Register')]")
    WebElement linkRegister;
    @FindBy(xpath = "//a[contains(text(),'Login')]")
    WebElement linkLogin;

//Action Methods
    public void clickMyAccount(){
        linkMyAccount.click();
    }
    public void clickRegister(){
        linkRegister.click();
    }
    public void clickLogin(){
        linkLogin.click();
    }
}
