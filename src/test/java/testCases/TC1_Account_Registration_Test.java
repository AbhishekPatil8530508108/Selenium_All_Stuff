package testCases;

import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.Home_Page;
import pageObject.Registration_Test_Page;

@Slf4j
public class TC1_Account_Registration_Test extends T_Base_Class {
    @Test(groups = {"Master","Regression"})
    public void verify_Account_Registration() {
//        To Access Home Page object we have to create object of home page
        logger.info("Starting TC1_Account_Registration_Test");
        try {
            Home_Page h_p = new Home_Page(driver);
            h_p.clickMyAccount();
            logger.info("Clicked on My Account");
            h_p.clickRegister();
            logger.info("Clicked on Register Page");
//         To Access Registration Page object we have to create object of home page
            logger.info("Providing All Related Data");
            Registration_Test_Page r_t_p = new Registration_Test_Page(driver);
            r_t_p.setFirstName(randomString().toUpperCase());
            r_t_p.setLastName(randomString().toUpperCase());
            r_t_p.setEmail(randomString() + "@gmail.com");
            r_t_p.setTelephone(randomAlphaNumeric());
//  To Enter Same Password In Both Password And Confirm Password
//  We Capture a Val In Variable And Store In String Variable
            String password=randomAlphaNumeric();
            r_t_p.setPassword(password);
            r_t_p.setConfirmPassword(password);
            r_t_p.clickPrivacyPolicy();
            r_t_p.clickContinue();
            logger.info("Validating Expected Text");
            String confMsg = r_t_p.checkConfirmationMsg();
            Assert.assertEquals(confMsg, "Your Account Has Been Created!");
        }
        catch (Exception e)
        {
            logger.error("Test Failed...");
            logger.debug("Debug logs....");
            Assert.fail();
        }
        logger.info("Finished TC1_Account_Registration_Test");

    }
}
