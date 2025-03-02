package org.TestNG.Grouping;

import org.testng.annotations.Test;

public class Grouping_Demo2 {
    @Test(priority = 1,groups = {"regression"})
    void signupByEmail(){
        System.out.println(" Sign Up Email");
    }
    @Test(priority = 2,groups = {"regression"})
    void signupByFacebook(){
        System.out.println(" Sign Up Facebook");
    }
    @Test(priority = 3,groups = {"regression"})
    void signupByTwitter(){
        System.out.println(" Sign Up Twitter");
    }
}
