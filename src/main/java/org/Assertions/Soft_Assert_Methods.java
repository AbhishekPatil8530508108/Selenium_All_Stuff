package org.Assertions;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Assert_Methods {
    @Test
    void soft(){
//  In Soft Assert We Have To Create The Object Od SoftAssert Is Mandatory
        SoftAssert sa=new SoftAssert();

        sa.assertEquals("xyz","xyz");
        //sa.assertEquals(123,345);

        //sa.assertEquals("abc",123);
        //sa.assertEquals("123",123);

        //sa.assertNotEquals(123,123);   // failed
        //sa.assertNotEquals(123,345);   //passed

        //sa.assertTrue(true);   //pass
        //Assert.assertTrue(false);  //failed

        //sa.assertTrue(1==2);   //fail
        //sa.assertTrue(1==1);   //passed

        //sa.assertFalse(1==2);  //passed
        //sa.assertFalse(1==1);  //failed

//        sa.fail();

//  sa.assertALL(); Is Mandatory to Pass Every Time In Soft Assert At Last
//  OR
//  We Get A Test As Pass Even The Test Is Fail
        sa.assertAll();
    }
}
