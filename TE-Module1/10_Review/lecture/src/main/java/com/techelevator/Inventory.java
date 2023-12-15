package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Inventory {

public Inventory() {
}

public Map<String,Item> buildInventory() {
    Item dogFood = new Item("Dog Food", 8.00, "Aaron", "F");
    dogFood.setSku("D4");
    Item crutches = new Item("Crutches", 47.89, "Niko", "M");
    crutches.setSku("C11");
    Item fedora = new Item("Fedora", 80.99, "stylish", "C");
    fedora.setSku("F2");

    Map<String, Item> inventoryList = new HashMap<>();
    inventoryList.put(dogFood.getSku(),dogFood);
    inventoryList.put(crutches.getSku(), crutches);
    inventoryList.put(fedora.getSku(), fedora);
    return inventoryList;
}

}









