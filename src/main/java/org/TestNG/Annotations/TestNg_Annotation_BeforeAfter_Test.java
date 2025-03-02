package org.TestNG.Annotations;

import org.testng.annotations.*;

public class TestNg_Annotation_BeforeAfter_Test {

    @BeforeTest
    void login(){
        System.out.println("Before Test Login");
    }
    @AfterTest
    void logout(){
        System.out.println("After Test Logout");
    }
    @Test(priority = 1)
    void search(){
        System.out.println("Search");
    }
    @Test(priority = 2)
    void advanceSearch(){
        System.out.println("Advance Search");
    }
}
