package com.techelevator;
import java.util.Scanner;
public class Greeting {

    public static void main(String[] args) {
        System.out.println("Welcome to my program!");
        System.out.println("Tell me the number of times you have crashed your car:");

        //make that Scanner thing
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        int numberOfCrashes = Integer.parseInt(userInput);
        System.out.println("You entered: " + numberOfCrashes * 3);
        System.out.println("Wow! That is bad driving!");


    }
}