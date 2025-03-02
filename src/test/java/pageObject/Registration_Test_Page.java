package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Registration_Test_Page extends Base_Class {
    public Registration_Test_Page(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[contains(@id,'input-firstname')]")
    WebElement txtFirstName;
    @FindBy(xpath = "//input[contains(@id,'input-lastname')]")
    WebElement txtLastName;
    @FindBy(xpath = "//input[contains(@id,'input-email')]")
    WebElement txtEmail;
    @FindBy(xpath = "//input[contains(@id,'input-telephone')]")
    WebElement txtTelephone;
    @FindBy(xpath = "//input[contains(@id,'input-password')]")
    WebElement txtPassword;
    @FindBy(xpath = "//input[contains(@id,'input-confirm')]")
    WebElement txtConfirmPassword;
    @FindBy(xpath = "//input[contains(@name,'agree')]")
    WebElement chkPrivacyPolicy;
    @FindBy(xpath = "//input[contains(@class,'btn btn-primary')]")
    WebElement btnContinue;
    @FindBy(xpath = "//h1[contains(text(),'Your Account Has Been Created!')]")
    WebElement msgConfirmation;

    public void setFirstName(String firstName){
        txtFirstName.sendKeys(firstName);
    }
    public void setLastName(String lastName){
        txtLastName.sendKeys(lastName);
    }
    public void setEmail(String email){
        txtEmail.sendKeys(email);
    }
    public void setTelephone(String telephone){
        txtTelephone.sendKeys(telephone);
    }
    public void setPassword(String password){
        txtPassword.sendKeys(password);
    }
    public void setConfirmPassword(String confirmPassword){
        txtConfirmPassword.sendKeys(confirmPassword);
    }
    public void clickPrivacyPolicy(){
        chkPrivacyPolicy.click();
    }
    public void clickContinue(){
        btnContinue.click();
    }
    public String checkConfirmationMsg(){
        try {
            return (msgConfirmation.getText());
        }
        catch (Exception e)
        {
            return (e.getMessage());
        }

    }
}
