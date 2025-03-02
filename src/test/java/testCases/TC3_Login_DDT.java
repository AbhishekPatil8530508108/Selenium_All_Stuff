package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Data_Providers;  // Correctly importing the data provider class
import pageObject.Home_Page;
import pageObject.Login_Page;
import pageObject.My_Account_Page;

public class TC3_Login_DDT extends T_Base_Class
{

    @Test(dataProvider = "LoginData", dataProviderClass = Data_Providers.class,groups = "Data driven") // Correct reference to data provider
    public void verify_Login_DDT(String email, String password, String expResult)
    {

        logger.info("***** Starting TC3_Login_DDT *****");

        try {
            // Navigate to Login Page
            Home_Page hp = new Home_Page(driver);
            hp.clickMyAccount();
            hp.clickLogin();

            // Enter Login Details
            Login_Page lp = new Login_Page(driver);
            lp.setEmail(email);
            lp.setPassword(password);
            lp.clickLogin();

            // Validate My Account Page
            My_Account_Page map = new My_Account_Page(driver);
            boolean targetPage = map.isMyAccountPageExist();

            // Simplified Assertion Logic
            if (expResult.equalsIgnoreCase("Valid"))
            {
                if (targetPage == true)
                {
                    map.clickLogout();
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }
            if (expResult.equalsIgnoreCase("Invalid"))
            {
                if (targetPage == true)
                {
                    map.clickLogout();
                    Assert.assertTrue(false);
                }
                else
                {
                    Assert.assertTrue(true);
                }
            }

        } catch (Exception e)
        {
            Assert.fail("Test execution failed due to an exception: " + e.getMessage());
        }

        logger.info("***** Finished TC3_Login_DDT *****");
    }
}
