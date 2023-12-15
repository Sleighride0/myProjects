package com.techelevator.items;

import com.techelevator.items.Item;

public class Food extends Item {

    private boolean isTaxable;
    public Food(String sku, boolean isTaxable) {
        super(sku);
        this.isTaxable = isTaxable;
    }

    public boolean isTaxable() {
        return isTaxable;
    }

    public void setTaxable(boolean taxable){
        this.isTaxable = taxable;

    }

    @Override
    public String getDepartment() {
        return "F";
    }
}
