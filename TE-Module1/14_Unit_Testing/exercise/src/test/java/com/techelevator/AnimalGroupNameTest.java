package com.techelevator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AnimalGroupNameTest {

    private AnimalGroupName animalGroupName;

    @Before
    public void setup() {
        animalGroupName = new AnimalGroupName();
    }

    @Test
    public void returns_String_Group_when_passed_animal_found(){
        String result = animalGroupName.getHerd("Rhino");
        Assert.assertEquals("Crash", result);
    }
    @Test
    public void returns_String_unknown_when_passed_animal_not_found_in_map(){
        String result = animalGroupName.getHerd("walrus");
        Assert.assertEquals("unknown", result);
    }
    @Test
    public void returns_String_Group_when_animal_passed_all_caps(){
        String result = animalGroupName.getHerd("RHINO");
        Assert.assertEquals("Crash", result);
    }
    @Test
    public void returns_String_Group_when_passed_animal_null(){
        String result = animalGroupName.getHerd(null);
        Assert.assertEquals("unknown", result);
    }
    @Test
    public void returns_String_Group_when_passed_empty_string(){
        String result = animalGroupName.getHerd("");
        Assert.assertEquals("unknown", result);
    }
}
