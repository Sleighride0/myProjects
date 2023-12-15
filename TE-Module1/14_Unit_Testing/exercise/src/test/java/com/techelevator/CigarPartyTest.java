package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CigarPartyTest {

    private CigarParty cigarParty;

    @Before
    public void setup() {
        cigarParty = new CigarParty();
    }

    @Test
    public void returns_true_if_cigars_between_40_to_60_not_weekend(){
        boolean result = cigarParty.haveParty(40, false);
        Assert.assertTrue(result);
    }
    @Test
    public void returns_false_if_cigars_outside_40_to_60_not_weekend(){
        boolean result = cigarParty.haveParty(30, false);
        Assert.assertFalse(result);
        //test should have passed to say this would return false
    }
    @Test
    public void returns_true_if_cigars_outside_40_to_60_and_is_weekend(){
        boolean result = cigarParty.haveParty(70, true);
        Assert.assertTrue(result);
    }












}
