package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Less20Test {

    private  Less20 less20;

    @Before
    public void setup(){
        less20 = new Less20();
    }
    @Test
    public void returns_false_if_exactly_multiple_of_20() {
        boolean result = less20.isLessThanMultipleOf20(40);
        Assert.assertFalse(result);
    }
    @Test
    public void returns_true_if_1_or_2_less_than_multiple_of_20() {
        boolean result = less20.isLessThanMultipleOf20(19);
        Assert.assertTrue(result);
    }
    @Test
    public void returns_false_if_not_1_or_2_less_than_multiple_of_20() {
        boolean result = less20.isLessThanMultipleOf20(21);
        Assert.assertFalse(result);

    }


















}
