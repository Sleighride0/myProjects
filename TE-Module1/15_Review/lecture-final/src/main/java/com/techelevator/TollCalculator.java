package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class TollCalculator {

    public static void main(String[] args) {

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car(false));
        vehicleList.add(new Car(true));
        vehicleList.add(new Tank());
        vehicleList.add(new Truck(4));
        vehicleList.add(new Truck(6));
        vehicleList.add(new Truck(8));

        System.out.println("Vehicle              Distance Traveled  Toll");
        System.out.println("___________________________________________________");
        for(Vehicle vehicle : vehicleList){
            int randomDistance = (int)(Math.random() * (240 - 10)) + 10;
            System.out.print(vehicle.toString());
            System.out.print(randomDistance);
            System.out.println("      " + vehicle.calculateToll(randomDistance));

        }
        System.out.println(vehicleList.get(0));
    }
}
