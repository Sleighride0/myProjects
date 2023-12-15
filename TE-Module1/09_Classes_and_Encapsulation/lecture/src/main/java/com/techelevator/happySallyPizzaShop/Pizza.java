package com.techelevator.happySallyPizzaShop;

import java.util.List;

public class Pizza {
    private String size;
    private List<String> toppings;
    // review getters and setters

    //constructor below
    public Pizza(String size){
        this.size = size;
    }
    public String getSize(){
        return size;
    }
    public void setSize(String size){
        this.size = size;
    }
    //void means it doesn't return something. give it the
    // input to set the variable


//derived property
    public double getPrice() {
        double price = 9.99;
        if(size.equalsIgnoreCase("large")){
            price = 14.99;
        } else if(size.equalsIgnoreCase("medium")){
            price = 11.99;
        }
        return price;
    }




    public List<String> getToppings() {
        return toppings;
    }

    public void setToppings(List<String> toppings) {
        this.toppings = toppings;
    }
}
