package com.techelevator;

public class Truck implements Vehicle {
    private int numberOfAxles;

    public Truck(int numberOfAxles){
        this.numberOfAxles = numberOfAxles;
    }


    public int getNumberOfAxles() {
        return numberOfAxles;
    }

    @Override
    public double calculateToll(int distance) {
        if (getNumberOfAxles()>=8){
            return distance * 0.048;
        }
        if(getNumberOfAxles()>=4){
            return distance * 0.045;
        }
        return distance * 0.40;
    }
}
