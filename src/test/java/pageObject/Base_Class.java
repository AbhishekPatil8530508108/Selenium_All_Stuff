package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Base_Class {
//    Parent Constructor
    WebDriver driver;
    public Base_Class(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
}
