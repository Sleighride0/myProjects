package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SameFirstLastTest {

    private SameFirstLast sameFirstLast;

    @Before
    public void setup(){
        sameFirstLast = new SameFirstLast();
    }
    @Test
    public void returns_false_if_empty_array() {
        int nums[] = new int[]{};
        boolean result = sameFirstLast.isItTheSame(nums);
        Assert.assertFalse(result);
    }
    @Test
    public void returns_true_if_array_of_1() {
        int nums[] = new int[]{2};
        boolean result = sameFirstLast.isItTheSame(nums);
        Assert.assertTrue(result);
    }

    @Test
    public void returns_false_if_array_first_and_last_dont_match() {
        int nums[] = new int[]{2,9};
        boolean result = sameFirstLast.isItTheSame(nums);
        Assert.assertFalse(result);
    }
    @Test
    public void returns_true_if_array_has_negatives_and_match() {
        int nums[] = new int[]{-2,5,-2};
        boolean result = sameFirstLast.isItTheSame(nums);
        Assert.assertTrue(result);
    }









}
