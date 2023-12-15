package com.techelevator;

public class Truck implements Vehicle{
    private int numberOfAxles;


    public Truck(int numberOfAxles){
        this.numberOfAxles = numberOfAxles;
    }

    @Override
    public double calculateToll(int distance) {
        double toll = 0.00;
        if(numberOfAxles == 4){
            toll = distance * .04;
        }else if(numberOfAxles == 6){
            toll = distance * .045;
        }else if(numberOfAxles >= 8){
            toll = distance * .048;
        }
        return toll;
    }

    public int getNumberOfAxles() {
        return numberOfAxles;
    }


    @Override
    public String toString() {
        if(numberOfAxles == 4){
            return "Truck (4 axels)    ";
        }else if(numberOfAxles == 6){
            return "Truck (6 axels)    ";
        }
        return "Truck (8 axels)   ";
    }
}
