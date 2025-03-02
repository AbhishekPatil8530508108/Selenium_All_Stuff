package org.TestNG.Annotations;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNg_Annotation_BeforeAfter_Method {

    @BeforeMethod
    void login(){
        System.out.println("Before Method Login");
    }
    @Test(priority = 1)
    void search(){
        System.out.println("Search");
    }
    @Test(priority = 2)
    void advanceSearch(){
        System.out.println("Advance Search");
    }
    @AfterMethod
    void logout(){
        System.out.println("After Method Logout");
    }
}
