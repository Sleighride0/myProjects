package com.techelevator;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//nextNumber is previous number + other previous number added together
		System.out.println("Please enter a number: ");
		String userInput = input.nextLine();
		Integer targetNumber = Integer.parseInt(userInput);
		int firstNumber = 0;
		int secondNumber = 1;
		int nextNumber = firstNumber + secondNumber;
		// the number 2000 is used so the for loop will not stop prior to breaking from the for loop


		for (int i = 0; i < secondNumber * 2000; i++) {
			if(targetNumber < 1){
				System.out.print("0, 1");
				break;
			}

			if(firstNumber > targetNumber){break;};
			System.out.print(firstNumber + ", ");
			if(secondNumber > targetNumber){break;};
			System.out.print(secondNumber + ", ");

					nextNumber = firstNumber + secondNumber;
					firstNumber = nextNumber;
					secondNumber = firstNumber + secondNumber;

				}
	}


}


