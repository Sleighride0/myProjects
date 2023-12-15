package com.techelevator.farm;

public class Tractor implements Singable{
    private String sound;
    private String name;
    private int gallonsOfGas = 30;

    public Tractor() {
        this.sound = "Vroom!!";
        this.name = "Tractor";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSound() {
        return sound;
    }

    public int remainingGallonsGas(){
        return gallonsOfGas;
    }
}
