package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NonStartTest {
    private NonStart nonStart;

    @Before
    public void setup(){
        nonStart = new NonStart();
    }
    @Test
    public void returns_0_length_string_when_nonStart_starting_1_char_strings() {
        String result = nonStart.getPartialString("x","a");
        Assert.assertEquals("", result);
    }
    @Test
    public void returns_nonStart_when_null() {
        String result = nonStart.getPartialString(null,"a");
        Assert.assertEquals("", result);
    }
    @Test
    public void returns_nonStart_when_empty_strings() {
        String result = nonStart.getPartialString("","ap");
        Assert.assertEquals("p", result);
    }





















}
