package com.techelevator;

import java.util.Scanner;

public class DecimalToBinary {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int currentValue = 0;
		int newDigit = 0;
		String currentString = "";
		String stringDigit = "";

		System.out.print("Please enter in a series of decimal values (separated by spaces): ");
		String userInput = input.nextLine();
		String[] decimalList = userInput.split(" ");
		for (int i = 0; i < decimalList.length; i++) {
			Integer startingValue = Integer.parseInt(decimalList[i]);
			System.out.print(startingValue + " in binary is ");
			currentString = "";
			if (startingValue == 0) {
				currentString = "0";
			}
			while (startingValue > 0) {

				newDigit = startingValue % 2;
				startingValue = startingValue / 2;
				stringDigit = String.valueOf(newDigit);
				currentString = stringDigit + currentString;

			} System.out.println(currentString);

		}





	}

}