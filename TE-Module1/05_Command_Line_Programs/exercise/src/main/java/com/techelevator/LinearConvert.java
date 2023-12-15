package com.techelevator;

import java.util.Scanner;

public class LinearConvert {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double lengthOutput = 0;

		System.out.println("Please enter the length: ");
		String userInput = input.nextLine();
		Double lengthInput = Double.parseDouble(userInput);

		System.out.println("Is the measurement in (m)eter, or (f)eet?");
		userInput = input.nextLine();
		String measureType = userInput;

		final double METER_TO_FEET = lengthInput * 3.2808399;
		final double FEET_TO_METERS = lengthInput * 0.3048;

		if (measureType.equals("m")) {
			lengthOutput = METER_TO_FEET;
			lengthOutput = (int) lengthOutput;
			System.out.println(lengthInput + "m is " + lengthOutput + "f");
		} else { lengthOutput = FEET_TO_METERS;
			lengthOutput = (int) lengthOutput;
			System.out.println(lengthInput + "f is " + lengthOutput + "m");
		}
	}
	}


