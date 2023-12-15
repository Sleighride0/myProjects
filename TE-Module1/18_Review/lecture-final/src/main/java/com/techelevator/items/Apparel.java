package com.techelevator.items;

public class Apparel extends Item{

    public Apparel(String sku) {
        super(sku);
    }

    public String getDepartment(){
        return "A";
    }

    @Override
    public String toString() {
        return "Apparel { " + super.getName() + " - $" + super.getPrice() + " }";
    }
}
