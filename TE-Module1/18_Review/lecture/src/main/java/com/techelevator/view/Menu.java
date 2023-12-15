package com.techelevator.view;

import com.techelevator.items.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    //This class holds all calls on Scanner(System.in) and System.out's
    private Scanner scanner = new Scanner(System.in);

    public String getHomeScreenOption() {
        System.out.println("What would you like to do?");
        System.out.println();

        System.out.println("D) Display Items");
        System.out.println("P) Purchase");
        System.out.println("E) Exit");

        System.out.print("Please select an option: ");

        String selectedOption = scanner.nextLine();
        String option = selectedOption.trim().toLowerCase();

        if (option.equals("d")) {
            option = "display";
        }
        else if (option.equals("p")) {
            option = "purchase";
        }
        else if (option.equals("e")) {
            option =  "exit";
        }
        else {
            option = "";
        }
        return option;
    }

    public void displayMessage(String message) {
        System.out.println();
        System.out.println(message);
    }

    public void displayHomeScreen() {
        System.out.println();
        System.out.println("***************************************************");
        System.out.println("                      Home");
        System.out.println("***************************************************");
        System.out.println();
    }

    public void displayInventory(Map<String, Item> inventory){
        for(Map.Entry<String,Item> currentEntry : inventory.entrySet()){
            String taxable = "NonTax";
            if(currentEntry.getValue().isTaxable()){
                taxable = "Taxable";
            }
            Item item = currentEntry.getValue();
            System.out.printf("%-10s : %-20s - $%5.2f -- %5s %n", "Code: "+ currentEntry.getKey(), item.getName(), item.getPrice(), taxable);
        }
    }

    public String getUserInput(){
        return scanner.nextLine();
    }

    public List<String> getUserCartSelections(String choice) {
        List<String> cartSkus = new ArrayList<>();
        while(choice.equalsIgnoreCase("purchase")){
            // make a purchase
            displayMessage("Please enter the sku of the item you wish to purchase or enter x when finished: ");
            String skuSelected = getUserInput();
            if(skuSelected.equalsIgnoreCase("x")){
                break;
            }
            //add sku selected to list of skus
           cartSkus.add(skuSelected);
        }
        return cartSkus;
    }
}
