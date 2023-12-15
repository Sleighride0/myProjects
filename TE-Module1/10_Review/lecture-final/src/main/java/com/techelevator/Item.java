package com.techelevator;

public class Item {

    private String itemName;
    private double itemPrice;
    private String itemDescription;
    private String category;

    private String sku;



    public Item(String itemName, double itemPrice, String itemDescription, String category){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemDescription = itemDescription;
        this.category = category;
    }
    public Item(){}

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription) {
        this.itemDescription = itemDescription;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", itemPrice=" + itemPrice +
                ", itemDescription='" + itemDescription + '\'' +
                ", category='" + category + '\'' +
                ", sku='" + sku + '\'' +
                '}';
    }
}
