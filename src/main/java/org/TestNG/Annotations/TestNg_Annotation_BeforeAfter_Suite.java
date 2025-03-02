package org.TestNG.Annotations;

import org.testng.annotations.*;

public class TestNg_Annotation_BeforeAfter_Suite {
    @BeforeSuite
    void login(){
        System.out.println("Before Suite Login");
    }
   @Test(priority = 1)
    void search(){
        System.out.println("Search");
    }
    @Test(priority = 2)
    void advanceSearch(){
        System.out.println("Advance Search");
    }
    @AfterSuite
    void logout(){
        System.out.println(" After Suite Logout");
    }
}
