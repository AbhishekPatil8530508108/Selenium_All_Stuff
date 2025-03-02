package org.TestNG.DemoExample;

import org.testng.annotations.Test;

public class TestNG_Demo {
    @Test(priority = 1)
    void openapp() {
        System.out.println("Opening the application");
    }

    @Test(priority = 2)
    void login() {
        System.out.println("loging the application");
    }

    @Test(priority = 3)
    void logout() {
        System.out.println("logging out the application");
    }
}
