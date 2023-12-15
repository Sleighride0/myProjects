package com.techelevator.items;

public class HomeGood extends Item{
    public HomeGood(String sku) {
        super(sku);
    }
    public String getDepartment(){
        return "HG";
    }

    @Override
    public String toString() {
        return "HomeGood { " + super.getName() + " - $" + super.getPrice() + " }";
    }
}
