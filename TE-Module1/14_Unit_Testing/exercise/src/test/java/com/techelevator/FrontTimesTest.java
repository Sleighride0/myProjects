package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FrontTimesTest {

    private FrontTimes frontTimes;

    @Before
    public void setup(){
        frontTimes = new FrontTimes();
    }
    @Test
    public void returns_string_equal_to_first_3_and_correct_number_of_times() {
        String result = frontTimes.generateString("blatant", 4);
        Assert.assertEquals("blablablabla", result);
    }
    @Test
    public void returns_string_less_than_length_3_and_correct_number_of_times() {
        String result = frontTimes.generateString("b", 4);
        Assert.assertEquals("bbbb", result);
    }
    @Test
    public void returns_empty_string_when_given_empty_string() {
        String result = frontTimes.generateString("", 4);
        Assert.assertEquals("", result);
    }
    @Test
    public void returns_empty_string_when_0_as_int_n() {
        String result = frontTimes.generateString("super", 0);
        Assert.assertEquals("", result);
    }












}
