package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObject.Home_Page;
import pageObject.Login_Page;
import pageObject.My_Account_Page;

public class TC2_Login_Test extends T_Base_Class {
    @Test(groups = {"Sanity","Master"})
    public void verify_Login(){
        logger.info("**********Starting TC2_Login_Test********");
//        homepage
        try {
            Home_Page hp = new Home_Page(driver);
            hp.clickMyAccount();
            hp.clickLogin();
//        login page
            Login_Page lp = new Login_Page(driver);
            lp.setEmail(p.getProperty("email"));
            lp.setPassword(p.getProperty("password"));
            lp.clickLogin();
//        myAccount
            My_Account_Page map = new My_Account_Page(driver);
            boolean targetPage = map.isMyAccountPageExist();
//        Assert.assertEquals(targetPage,true,"Login Failed");
//        or
            Assert.assertTrue(targetPage);
        }
        catch (Exception e)
        {
            Assert.fail();
        }
        logger.info("**********Finished TC2_Login_Test********");
    }
}
