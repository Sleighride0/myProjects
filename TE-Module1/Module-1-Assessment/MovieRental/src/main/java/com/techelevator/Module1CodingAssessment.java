package com.techelevator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Module1CodingAssessment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		MovieRental gold = new MovieRental("Goldfinger", "VHS", false);
		MovieRental goldeneye = new MovieRental("Goldeneye", "DVD", true);
		MovieRental drNo = new MovieRental("Dr. No", "Blu-Ray", true);
		System.out.println(gold.getRentalPrice());

		gold.lateFee(2);
		System.out.println(gold.toString());
		List<MovieRental> rentals = new ArrayList<>();
		rentals.add(gold);
		rentals.add(goldeneye);
		rentals.add(drNo);
		//rentalPrice = rentals.get(gold.getRentalPrice() + rentals.get(goldeneye.getRentalPrice() + rentals.get(drNo.getRentalPrice();
		//System.out.println(rentalPrice);


	}
}
