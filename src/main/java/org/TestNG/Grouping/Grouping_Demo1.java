package org.TestNG.Grouping;

import org.testng.annotations.Test;

public class Grouping_Demo1 {
    @Test(priority = 1,groups = {"sanity"})
    void loginByEmail(){
        System.out.println(" Login By Email");
    }
    @Test(priority = 2,groups = {"sanity"})
    void loginByFacebook(){
        System.out.println(" Login By Facebook");
    }
    @Test(priority = 3,groups = {"sanity"})
    void loginByTwitter(){
        System.out.println(" Login By Twitter");
    }
}
