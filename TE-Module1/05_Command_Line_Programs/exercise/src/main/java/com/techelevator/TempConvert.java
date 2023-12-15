package com.techelevator;

import java.util.Scanner;
public class TempConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double tempOutput = 0;
		System.out.println("Please enter the temperature: ");
		String userInput = input.nextLine();
		Double temperatureInput = Double.parseDouble(userInput);

		System.out.println("Is the temperature in (C)elsius, or (F)ahrenheit?: ");
		userInput = input.nextLine();
		String tempType = userInput;

		if (tempType.equals("C")){
			tempOutput = temperatureInput * 1.8 + 32;
			if (temperatureInput.equals(tempOutput)) {
				System.out.print("The strings are equal. ");
			}
			System.out.println(temperatureInput +"C is " + tempOutput + "F");
		}
		tempOutput = (temperatureInput - 32) / 1.8;
		if (temperatureInput.equals(tempOutput)) {
			System.out.print("The strings are equal. ");
		}
		System.out.println(temperatureInput +"F is " + tempOutput + "C");
	}

}
