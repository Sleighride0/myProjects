package com.techelevator.items;

public class Item {

    private String itemID;
    private String type;
    private String name;
    private String hasWrapper;
    private int quantity = 100;
    private double price;
    private String desc;

    public Item(String[] array) {
        for (int i = 0; i < array.length; i++) {
            this.itemID = array[1];
            this.name = array[2];
            //dont need a full if statement b/c its already a boolean checking for T/F
            this.hasWrapper = array[4].equals("T")?"Y":"N";
            this.price = Double.parseDouble(array[3]);
            this.type = array[0];
            this.desc = setDesc(array[0]);
        }

    }

    public String getType() {
        return type;
    }

    public String getHasWrapper() {
        return hasWrapper;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemID='" + itemID + '\'' +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", hasWrapper=" + hasWrapper +
                ", quantity=" + quantity +
                ", price=" + price +
                ", desc='" + desc + '\'' +
                '}';
    }

    //    public Item(String[] array){
//      // This is where we can iterate and pass in the variable directly.
//    }


    public String getItemID() {
        return itemID;
    }

    public String getName() {
        return name;
    }

    public String isHasWrapper() {
        return hasWrapper;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHasWrapper(String hasWrapper) {
        this.hasWrapper = hasWrapper;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String setDesc(String type) {
        if (type.equalsIgnoreCase("CH")) {
            return "Chocolate Confectionery";
        }
        if (type.equalsIgnoreCase("SR")) {
            return "Sour Flavored";
        }
        if (type.equalsIgnoreCase("HC")) {
            return "Hard Tack Confectionery";
        }
        if (type.equalsIgnoreCase("LI")) {
            return "Licorce and Jellies";

        }
        return "Nothing here";
    }
}
