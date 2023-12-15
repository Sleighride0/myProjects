package com.techelevator;

public class Car implements Vehicle{

    private boolean hasTrailer;


    public Car(boolean hasTrailer){
        this.hasTrailer = hasTrailer;
    }
    @Override
    public double calculateToll(int distance) {
        double toll = distance * .020;
        if(hasTrailer){
            toll += 1;
        }
        return toll;
    }

    public boolean hasTrailer() {
        return hasTrailer;
    }

    @Override
    public String toString() {
        if(hasTrailer){
            return "Car (with trailer)     ";
        }
        return "Car                 ";
    }
}
