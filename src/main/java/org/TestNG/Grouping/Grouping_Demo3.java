package org.TestNG.Grouping;

import org.testng.annotations.Test;

public class Grouping_Demo3 {
    @Test(priority = 1,groups = {"sanity","regression","functional"})
    void paymentInRupees(){
        System.out.println(" Payment In Rupees");
    }
    @Test(priority = 2,groups = {"sanity","regression","functional"})
    void paymentInDollars(){
        System.out.println(" Payment In Dollars");
    }
}
