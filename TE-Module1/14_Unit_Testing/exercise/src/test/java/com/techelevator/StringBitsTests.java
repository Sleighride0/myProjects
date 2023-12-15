package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringBitsTests {

    private StringBits stringBits;

    @Before
    public void setup() {
        stringBits = new StringBits();
    }

    @Test
    public void return_string_when_just_1_in_string() {
        String result = stringBits.getBits("H");
        Assert.assertEquals("H", result);
    }

    @Test
    public void return_empty_string_when_passed_empty_string() {
        String result = stringBits.getBits("");
        Assert.assertEquals("", result);
    }
@Test
    public void return_first_char_only_when_passed_2_char_string() {
        String result = stringBits.getBits("fe");
        Assert.assertEquals("f", result);
    }



}
