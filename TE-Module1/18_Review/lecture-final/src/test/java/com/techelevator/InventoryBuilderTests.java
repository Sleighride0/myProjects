package com.techelevator;

import com.techelevator.items.Item;
import com.techelevator.items.filereader.InventoryBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

public class InventoryBuilderTests {

    private InventoryBuilder inventoryBuilder;

    private String inventoryfilePath;
    @Before
    public void setup(){
        inventoryBuilder = new InventoryBuilder(inventoryfilePath);
    }

@Test
public void returns_string_equal_to_first_3_and_correct_number_of_times() {
    Map<String, Item> result = inventoryBuilder.getInventory();
    Assert.assertEquals("blablablabla", result);
}
}