package org.TestNG.Dependency_Methods;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Dependency_Methods {
    @Test(priority = 1)
    void openApp(){
        System.out.println("Open App");
        Assert.assertTrue(true);
    }
    @Test(priority = 2, dependsOnMethods = {"openApp"})
    void login(){
        System.out.println("Login");
        Assert.assertTrue(false);
    }
    @Test(priority = 3, dependsOnMethods = {"login"})
    void search(){
        System.out.println("Search");
        Assert.assertTrue(true);
    }
    @Test(priority = 4, dependsOnMethods = {"login","search"})
    void advanceSearch(){
        System.out.println("Advance Search");
        Assert.assertTrue(true);
    }
    @Test(priority = 5, dependsOnMethods = {"login"})
    void logOut(){
        System.out.println("Logged Out");
        Assert.assertTrue(true);
    }
}
