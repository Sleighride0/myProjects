package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class TollBoothCalculator {

    public static void main(String[] args) {


//make list<vehicle>
        //loop over the list and get type, distance, getCalctoll
        //distance counter outside the loop
        //counter toll money

        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Car(false));
        vehicleList.add(new Car(true));
        vehicleList.add(new Tank());
        vehicleList.add(new Truck (4));
        vehicleList.add(new Truck (6));
        vehicleList.add(new Truck (8));
//random number generator below
        int randomDistance = (int)(Math.random() * (240-10) + 10);
        double totalDistance = 0;
        double totalToll = 0;
        for(Vehicle current : vehicleList){
            current.calculateToll();
            totalDistance += current.calculateToll(100);
            System.out.println(current + );

        Car car = new Car(true);

        Truck truck = new Truck();

        Tank tank = new Tank();


    }
}
