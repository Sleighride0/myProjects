package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private int balance;

//    public void displayInventory(Map<String, Item> inventory) {
//
//    }


    public void getSubMenu() {

    }

    //add this
    public String getUserInput(){
        return scanner.nextLine();
    }
    public String getMainMenu() {
        System.out.println("(1) Show Inventory");
        System.out.println("(2) Make Sale");
        System.out.println("(3) Quit");

    //add this
     System.out.print("Please select an option: ");

    String selectedOption = scanner.nextLine();
    String option = selectedOption.trim().toLowerCase();

        if (option.equals("1")) {
        option = "Show Inventory";
    }
        else if (option.equals("2")) {
        option = "Make Sale";
    }
        else if (option.equals("3")) {
        option =  "exit";
    }
        return option;
}
//    public List<String> getUserCartSelections(String choice) {
//        List<String> cartSkus = new ArrayList<>();
//        while(choice.equalsIgnoreCase("purchase")){
//            // make a purchase
//            displayMessage("Please enter the sku of the item you wish to purchase or enter x when finished: ");
//            String skuSelected = getUserInput();
//            if(skuSelected.equalsIgnoreCase("x")){
//                break;
//            }
//            //add sku selected to list of skus
//            cartSkus.add(skuSelected);
//        }
//        return cartSkus;
//    }
}











