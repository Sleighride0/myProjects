package com.techelevator.items;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
    private Item item;
    private final String ERROR_DESC_CHOCOLATE = "Error Chocolate Confectionery type";
    private final String ERROR_DESC_SOUR = "Error Sour Flavored type";
    private final String ERROR_DESC_HARD_TACK = "Error Hard Tack Confectionery type";
    private final String ERROR_DESC_LICORCE = "Error Licorce and Jellies type";
    private final String ERROR_DESC_DEFAULT = "Error unspecified type";

    @Before
    public void setup() {
        String[] testData = {"CH", "123", "Chocolate Bar", "1.99", "T"};
        item = new Item(testData);
    }

    @Test
    public void testDescriptionForCHType() {
        Assert.assertEquals(ERROR_DESC_CHOCOLATE, "Chocolate Confectionery", item.setDesc("CH"));
    }


    @Test
    public void testItemID() {
        Assert.assertEquals("Error when fetching ItemID", "123", item.getItemID());
    }

    @Test
    public void testName() {
        Assert.assertEquals("Error when fetching Item Name", "Chocolate Bar", item.getName());
    }
}



