package com.techelevator;

import java.util.Map;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Map<String,Item> storeInventory = inventory.buildInventory();
        System.out.println("Welcome to Java Blue Store! ");
        System.out.println("Check out our inventory:");

        for(Map.Entry<String,Item> currentEntry : storeInventory.entrySet()){
            Item currentItem = currentEntry.getValue();
            System.out.println(currentItem);
        }

        double totalOfSelectedItems = 0.00;
        Scanner input = new Scanner(System.in);
        boolean keepShopping = true;
        while(keepShopping){
            System.out.println("Please enter the code of the item you wish to purchase, enter x to finish: ");
            String userInput = input.nextLine();
            if(userInput.equalsIgnoreCase("x")){
                keepShopping = false;
            } else{
                double price = storeInventory.get(userInput.toUpperCase()).getItemPrice();
                totalOfSelectedItems += price;
                System.out.println("You have selected " + storeInventory.get(userInput.toUpperCase()).getItemName());
                System.out.println("Your new total is: $" + totalOfSelectedItems);
            }
        }

        System.out.println("Thank you for shopping with us.");

    }

}
