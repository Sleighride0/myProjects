package com.techelevator.store;

public class DiscountedProduct extends Product{

    private double discountRate;

    public DiscountedProduct(String name, double discountRate){

        super(name,calculateDiscountedPrice(discountRate));
        this.discountRate = discountRate;
    }


    public double getDiscountRate() {
        return discountRate;
    }

    private static double calculateDiscountedPrice(double discountRate){
        //say all discount product start with a price of 100
        double allDiscountProductStartingPrice = 100;
        return allDiscountProductStartingPrice - (discountRate * allDiscountProductStartingPrice);
    }
}
