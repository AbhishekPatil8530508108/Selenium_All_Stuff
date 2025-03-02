package org.Assertions;

import org.junit.Test;
import org.testng.Assert;
public class Assertion_Demo {
    @Test
    public void test() {
        String expected = "Abhishek";
        String actual = "Abhishek";
        Assert.assertEquals(expected,actual);

    }
}
