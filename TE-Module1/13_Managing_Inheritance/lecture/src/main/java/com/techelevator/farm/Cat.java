package com.techelevator.farm;

public class Cat extends FarmAnimal {
    public Cat() {
        super("Cat", "meow!");
    }

    @Override
    public String eat() {
        return "meow mix";
    }
//    @Override
//    public String getSound() {
//        return "meow!";
//    }
}
