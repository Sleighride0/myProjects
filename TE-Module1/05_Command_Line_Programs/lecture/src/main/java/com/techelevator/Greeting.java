package com.techelevator;
import java.util.Scanner;
public class Greeting {

    public static void main(String[] args){
        System.out.println("Welcome to my program!");
        System.out.println("Tell me the worst advice you have ever received.");

        //make the scanner
        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();        //takes user input and assigns in to this string
        int numberOfCrashes = Integer.parseInt(userInput);
        System.out.println("You entered: " + numberOfCrashes *3);
        System.out.println("Wow! That is bad advice!");

    }

    Scanner input = new Scanner(System.in);
    //nextnumber is previous number + other previous number added together
		System.out.println("Please enter a number: ");
    String userInput = input.nextLine();
    Integer targetNumber = Integer.parseInt(userInput);
    int firstNumber = 0;
    int secondNumber = 1;
    int nextNumber = firstNumber + secondNumber;

		for (int i = 0; i < targetNumber; i++) {
        System.out.print(firstNumber + ", " + secondNumber + ", ");
        nextNumber = firstNumber + secondNumber;
        firstNumber = nextNumber;
        secondNumber = firstNumber + secondNumber;
    }
}



}


