package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaxEnd3Test {

    private MaxEnd3 maxEnd3;

    @Before
    public void setup(){
        maxEnd3 = new MaxEnd3();
    }
    @Test
    public void returns_largest_if_index_0_is_largest() {
        int[] result = maxEnd3.makeArray(new int[]{3, 0, 2});
        int[] expected = {3, 3, 3};
        Assert.assertArrayEquals(expected, result);
    }
    @Test
    public void returns_largest_if_index_1_is_largest() {
        int[] result = maxEnd3.makeArray(new int[]{3, 9, 2});
        int[] expected = {3, 3, 3};
        Assert.assertArrayEquals(expected, result);
    }
    @Test
    public void returns_largest_if_largest_is_negative() {
        int[] result = maxEnd3.makeArray(new int[]{-11, 0, -3});
        int[] expected = {-3, -3, -3};
        Assert.assertArrayEquals(expected, result);
        //should have returned
    }
    @Test
    public void returns_largest_if_index_0_and_2_equal() {
        int[] result = maxEnd3.makeArray(new int[]{4, 5, 4});
        int[] expected = {4, 4, 4};
        Assert.assertArrayEquals(expected, result);
    }




























}
