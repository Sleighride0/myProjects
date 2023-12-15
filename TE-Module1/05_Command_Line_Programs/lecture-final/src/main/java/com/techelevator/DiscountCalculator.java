package com.techelevator;

import java.util.Scanner;

class DiscountCalculator {

    /**
     * The main method is the start and end of our program
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Discount Calculator");

        // Prompt the user for a discount amount
        // The answer needs to be saved as a double
        System.out.print("Enter the discount amount (w/out percentage): ");
        //use scanner and call nextLine() to get discount amt from user
        String discountStr = scanner.nextLine();
        double discount = Double.parseDouble(discountStr) / 100;

        // Prompt the user for a series of prices
        System.out.print("Please provide a series of prices (space separated): ");

        //get user input using the scanner again and calling nextLine()
        String priceStr = scanner.nextLine();
        //they will give me a string of numbers separated by spaces - need to breakup that string
        //aka priceStr is a string with a bunch of numbers separated by spaces
        String[] priceArray = priceStr.split(" ");
        //now I have an array of strings representing prices - need to look at each string and apply discount
        System.out.println("You entered a discount of: " + discountStr + "%");

        for(int i = 0; i < priceArray.length; i++){
            //access each element and do what we did with one number
            double priceDbl = Double.parseDouble(priceArray[i]);
            double amountToDiscount = priceDbl * discount;
            double itemPrice = priceDbl - amountToDiscount;
            System.out.println("Original price: " + priceDbl + " -- New Discounted Price: " + itemPrice);
        }




    }

}