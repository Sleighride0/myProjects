package com.techelevator;

public class Elevator {
    private int currentFloor = 1;

    private int numberOfFloors;

    private boolean doorOpen;


    public int getCurrentFloor() {
        if (currentFloor > numberOfFloors){
            currentFloor = numberOfFloors;
        }
        return currentFloor;
    }

    public int getNumberOfFloors() {
        return numberOfFloors;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public Elevator(int numberOfLevels) {
        numberOfFloors = numberOfLevels;
    }

    public void openDoor() {
        doorOpen = true;
    }

    public void closeDoor() {
        doorOpen = false;
    }

    public void goUp(int desiredFloor){
        if (doorOpen != true){
            if (desiredFloor > numberOfFloors) {
                currentFloor = numberOfFloors;
            }
            if (desiredFloor > currentFloor){
                currentFloor = desiredFloor;
            }
        }
    }

    public void goDown(int desiredFloor) {
        if (doorOpen != true) {
            if (desiredFloor < 1) {
                currentFloor = 1;
            } else if (desiredFloor >= currentFloor) {
                desiredFloor = currentFloor;
            } else {currentFloor = desiredFloor;
            }
        }
    }


}
