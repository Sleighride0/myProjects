package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DateFashionTest {

    private DateFashion dateFashion;

    @Before
    public void setup() {
       dateFashion = new DateFashion();
    }

    @Test
    public void returns_int_0_if_one_person_is_score_2_or_less_and_other_is_10() {
        int result = dateFashion.getATable(2,10);
        Assert.assertEquals(0, result);
    }
    @Test
    public void returns_int_2_if_one_person_is_8_plus_and_other_is_3_or_higher() {
        int result = dateFashion.getATable(8,3);
        Assert.assertEquals(2, result);
    }
    @Test
    public void returns_int_1_if_both_above_2_and_below_7() {
        int result = dateFashion.getATable(3,7);
        Assert.assertEquals(1, result);
    }
    @Test
    public void returns_1_if_int_outside_of_range() {
        int result = dateFashion.getATable(-4,13);
        Assert.assertEquals(1, result);
        //shouldve returned 1 as getTable=1 was set in the method. no info about how to handle negatives or above 10
    }























}
