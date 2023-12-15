package com.techelevator.happySallyPizzaShop;

import java.util.ArrayList;
import java.util.List;

public class HappyPizzaShop {
    public static void main(String[] args) {
        Pizza smallCheese = new Pizza("small");
        List<String> toppings = new ArrayList<>();
        toppings.add("green pepper");
        toppings.add("black olives");
        smallCheese.setToppings(toppings);
        System.out.println(smallCheese.getSize());
        System.out.println(smallCheese.getToppings());
        System.out.println(smallCheese.getPrice());

        Pizza largePizza = new Pizza("large");
        List<String> largeToppings = new ArrayList<>();
        largeToppings.add("anchovies");
        largeToppings.add("chicken");
        largePizza.setToppings(largeToppings);
        System.out.println(largePizza.getPrice());
        System.out.println(largePizza.getSize());
        System.out.println(largePizza.getToppings());

    }
}
