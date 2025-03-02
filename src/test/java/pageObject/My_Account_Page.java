package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_Account_Page extends Base_Class{
    public My_Account_Page(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement msgMyAccount;
    @FindBy(xpath = "//div[@class='list-group']//a[text()='Logout']")
    WebElement btnLogout;

    public boolean isMyAccountPageExist(){
        try {
            return(msgMyAccount.isDisplayed());
        }
        catch (Exception e)
        {
            return false;
        }
    }
    public void clickLogout(){
        btnLogout.click();
    }
}
