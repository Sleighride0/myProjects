package com.techelevator.items;

public class Food extends Item{
    private boolean isTaxable;

    public Food(String sku, boolean isTaxable) {
        super(sku);
        this.isTaxable = isTaxable;
    }

    public boolean isTaxable() {
        return isTaxable;
    }


    public String getDepartment(){
        if(isTaxable){
            return "FTX";
        }
        return "F";
    }

    @Override
    public String toString() {
        String taxable = "";
        if(isTaxable){
            taxable = "taxable";
        }
        return "Food is yummy { " + super.getName() +" - $"+ super.getPrice() +
                " " + taxable +
                '}';
    }
}
