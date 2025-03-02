package org.TestNG.Annotations;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestNg_Annotation_BeforeAfter_Class {

    @BeforeClass
    void login(){
        System.out.println("Before Class Login");
    }
    @AfterClass
    void logout(){
        System.out.println("After Class Logout");
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
