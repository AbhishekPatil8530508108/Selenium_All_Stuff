package org.TestNG.Annotations;

import org.testng.annotations.*;

public class TestNg_All_Annotations {

    @BeforeSuite
    void beforeSuit(){
        System.out.println("Before Suite");
    }
    @AfterSuite
    void afterSuit(){
        System.out.println("After Suite");
    }
    @BeforeTest
    void beforeTest(){
        System.out.println("Before Test");
    }
    @AfterTest
    void fterTest(){
        System.out.println("After Test");
    }
    @BeforeMethod
    void beforeMethod(){
        System.out.println("Before Method");
    }
    @AfterMethod
    void afterMethod(){
        System.out.println("After Method");
    }
    @BeforeClass
    void beforeClass(){
        System.out.println("Before Class");
    }
    @AfterClass
    void afterClass(){
        System.out.println("After Class");
    }
    @Test(priority = 1)
    void search(){
        System.out.println("Test Priority1 Search");
    }
    @Test(priority = 2)
    void advanceSearch(){
        System.out.println("Test Priority2 Advance Search");
    }

}
