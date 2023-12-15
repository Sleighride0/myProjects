package com.techelevator.store;

import com.techelevator.farm.FarmAnimal;

public class Frog extends FarmAnimal {

    public Frog(String name, String sound) {
        super(name, sound);
    }

    @Override
    protected String eat() {
return "";
    }

//    @Override
//    protected void setAsleep(boolean asleep) {
//        super.setAsleep(asleep);
//    }
}
