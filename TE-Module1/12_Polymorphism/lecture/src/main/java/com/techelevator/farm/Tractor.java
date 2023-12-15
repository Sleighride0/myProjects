package com.techelevator.farm;

public class Tractor implements Singable{
private String sound;
private String name;


    public Tractor() {
    this.sound = "Vroom!";
    this.name = "Tractor";
    }


    @Override
    public String getName() {
        //this override is more for readability
        return name;
    }

    @Override
    public String getSound() {
        return sound;
    }
}
