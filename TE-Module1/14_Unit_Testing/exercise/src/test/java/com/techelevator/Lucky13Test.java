package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Lucky13Test {

    private Lucky13 lucky13;


    @Before
    public void setup(){
        lucky13 = new Lucky13();
    }

    @Test
    public void returns_true_if_no_1_and_no_3() {
        int nums[] = new int[]{0,4,5,9};
        boolean result = lucky13.getLucky(nums);
        Assert.assertTrue(result);
    }
    @Test
    public void returns_false_if_contains_1() {
        int nums[] = new int[]{1,4};
        boolean result = lucky13.getLucky(nums);
        Assert.assertFalse(result);

    }
    @Test
    public void returns_false_if_contains_3() {
        int nums[] = new int[]{3,4};
        boolean result = lucky13.getLucky(nums);
        Assert.assertFalse(result);


    }
    @Test
    public void returns_true_if_negative_included() {
        int nums[] = new int[]{0,-4,5,9};
        boolean result = lucky13.getLucky(nums);
        Assert.assertTrue(result);
    }
    @Test
    public void returns_true_if_empty_array() {
        int nums[] = new int[]{};
        boolean result = lucky13.getLucky(nums);
        Assert.assertTrue(result);
    }

















}
