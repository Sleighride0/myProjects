package com.techelevator;

import org.junit.Assert;
import org.junit.Test;

public class CarTest {

    @Test
    public void car_with_no_trailer_traveling_10_miles_returns_20_cents(){
        //arrange
        Car car = new Car(false);
        //act
        double toll = car.calculateToll(10);
        Assert.assertEquals(.20, toll, .009);
    }

}
