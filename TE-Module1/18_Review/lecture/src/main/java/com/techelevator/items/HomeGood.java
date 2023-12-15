package com.techelevator.items;

import com.techelevator.items.Item;

public class HomeGood extends Item {


    public HomeGood(String sku) {
        super(sku);
    }


    @Override
    public String getDepartment() {
        return "HG";
    }
}
