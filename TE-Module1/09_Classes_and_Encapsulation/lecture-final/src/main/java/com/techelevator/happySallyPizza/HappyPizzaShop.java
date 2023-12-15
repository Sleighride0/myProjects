package com.techelevator.happySallyPizza;

import java.util.ArrayList;
import java.util.List;

public class HappyPizzaShop {

    public static void main(String[] args) {
        //use the Pizza class to make an instance of a pizza
        //and use the constructor in Pizza class that takes a string to rep the size
        Pizza smallCheese = new Pizza("small");

        //create a list of strings to hold the toppings
        List<String> listyToppings = new ArrayList<>();
        listyToppings.add("green pepper");
        listyToppings.add("black olives");
        //calling the setToppings() setter to give our instance toppings
        smallCheese.setToppings(listyToppings);

        //print to the console the state of our pizza
        System.out.println(smallCheese.getSize());
        System.out.println(smallCheese.getToppings());
        System.out.println(smallCheese.getPrice());

        //use the Pizza class to make an instance of a pizza
        //and use the no argument constructor so you will need to call setSize()
        Pizza largePizza = new Pizza();
        largePizza.setSize("large");

        //reassign listyToppings to a new array list to clear out old toppings
        listyToppings = new ArrayList<>();
        listyToppings.add("anchovies");
        listyToppings.add("chicken");

        //calling the setToppings() setter to give our instance toppings
        largePizza.setToppings(listyToppings);



        System.out.println(largePizza);
        //print to the console the state of our second pizza
        System.out.println(largePizza.getPrice());
        System.out.println(largePizza.getSize());
        System.out.println(largePizza.getToppings());

    }
}
