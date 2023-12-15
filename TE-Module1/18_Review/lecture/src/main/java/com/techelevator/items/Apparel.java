package com.techelevator.items;

import com.techelevator.items.Item;

public class Apparel extends Item {
    public Apparel(String sku) {
        super(sku);
    }


    @Override
    public String getDepartment() {
        return "A";
    }
}
