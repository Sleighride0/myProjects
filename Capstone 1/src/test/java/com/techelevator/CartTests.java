package com.techelevator;

import com.techelevator.items.Item;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CartTests {
    private Cart cart;
    private Map<String, Item> sampleInventory;

    @Before
    public void setUp() {
        cart = new Cart();
        sampleInventory = new HashMap<>();
        sampleInventory.put("A1", new Item(new String[]{ "SampleItem1","A1", "SampleDesc1", "1.00", "5"}));
        sampleInventory.put("A2", new Item(new String[]{ "SampleItem2","A2", "SampleDesc2", "2.00", "5"}));
    }

    @Test
    public void testAddItemToCart() {
        cart.getShoppingCart().add(sampleInventory.get("A1"));
        assertEquals(1, cart.getShoppingCart().size());
        assertEquals(1.00, cart.getTotal(), 0.001);
    }

    @Test
    public void testMultipleItemsInCart() {
        cart.getShoppingCart().add(sampleInventory.get("A1"));
        cart.getShoppingCart().add(sampleInventory.get("A2"));
        assertEquals(2, cart.getShoppingCart().size());
        assertEquals(3.00, cart.getTotal(), 0.001);
    }

    @Test
    public void testCartCountSingleItem() {
        cart.getShoppingCart().add(sampleInventory.get("A1"));
        Map<String, Integer> count = cart.cartCount();
        assertEquals(1, count.get("A1").intValue());
    }

    @Test
    public void testCartCountMultipleItems() {
        cart.getShoppingCart().add(sampleInventory.get("A1"));
        cart.getShoppingCart().add(sampleInventory.get("A1"));
        cart.getShoppingCart().add(sampleInventory.get("A2"));
        Map<String, Integer> count = cart.cartCount();
        assertEquals(2, count.get("A1").intValue());
        assertEquals(1, count.get("A2").intValue());

    }

}
