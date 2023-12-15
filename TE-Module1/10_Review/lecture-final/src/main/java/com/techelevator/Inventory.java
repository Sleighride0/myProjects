package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

    public Map<String,Item> buildInventory(){

        Map<String,Item> inventory = new HashMap<>();

        Item watch = new Item("gold watch", 200.00, "fancy gold watch", "C");
        watch.setSku("A1");
        Item waterbottle = new Item("water bottle", 19.99, "stainless-steel water bottle with straw", "M");
        waterbottle.setSku("B1");
        Item shirt = new Item();
        shirt.setItemName("TE shirt");
        shirt.setItemPrice(10.00);
        shirt.setItemDescription("Amazing TE shirt, now with sleeves!!");
        shirt.setCategory("C");
        shirt.setSku("C1");

        inventory.put("A1", watch);
        inventory.put("B1", waterbottle);
        inventory.put(shirt.getSku(), shirt);

        return inventory;
    }

}
