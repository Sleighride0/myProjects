package com.techelevator.view;




import java.util.Scanner;

public class Menu {

    private final Scanner userInput = new Scanner(System.in);

    public String getSelectionFromMainMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1) List Students");
        System.out.println("2) Generate a random question");
        System.out.println("3) Generate a random question and assign it to a student");
        System.out.println("Q) Quit");

        String userSelection = "";
        while (true) {
            userSelection = userInput.nextLine().toUpperCase();
            switch (userSelection) {
                case "1":
                    return userSelection;
                case "2":
                    return userSelection;
                case "3":
                    return userSelection;
                case "Q":
                    return userSelection;
                default:
                    System.out.println("Incorrect input, try again!");

            }
        }




    }








}
