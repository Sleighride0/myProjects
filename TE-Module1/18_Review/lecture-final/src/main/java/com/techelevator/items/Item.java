package com.techelevator.items;

import java.math.BigDecimal;

public abstract class Item {

    private BigDecimal price;
    private String name;
    private String description;
    private String sku;
    private boolean isTaxable = true;


    //constructor
    public Item(String sku) {
        this.sku = sku;
    }


    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSku() {
        return sku;
    }


    public boolean isTaxable(){
        return isTaxable;
    }

    public void setTaxable(boolean isTaxable){
        this.isTaxable = isTaxable;
    }

}
