package com.techelevator.store;

public class DiscountedProduct extends Product{
private double discountRate;
    public DiscountedProduct(String name, double discountRate) {
        super(name, calculateDiscountedPrice(discountRate));
        this.discountRate = discountRate;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    private static double calculateDiscountedPrice(double discountRate){
        //say all products start with a price of 100
        double allDscountedProductStartingPrice = 100;
        return allDscountedProductStartingPrice - (discountRate * allDscountedProductStartingPrice);
    }


}
