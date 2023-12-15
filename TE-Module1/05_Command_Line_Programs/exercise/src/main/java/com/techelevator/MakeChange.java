package com.techelevator;

import java.util.Scanner;

/*
 Write a command line program which prompts the user for the total bill, and the amount tendered. It should then
 display the change required.

 Please enter the amount of the bill: 23.65
 Please enter the amount tendered: 100.00
 The change required is 76.35
 */
public class MakeChange {

	public static void main(String[] args) {
		Scanner input  = new Scanner(System.in);

		System.out.println("Please enter the amount of the bill: ");
		String userInput = input.nextLine();
		Double billAmount = Double.parseDouble(userInput);

		System.out.println("Please enter the amount tendered: ");
		userInput = input.nextLine();
		Double tenderedAmount = Double.parseDouble(userInput);
	}

}
