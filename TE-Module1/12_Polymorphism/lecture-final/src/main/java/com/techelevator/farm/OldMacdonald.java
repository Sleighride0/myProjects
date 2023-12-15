package com.techelevator.farm;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class OldMacdonald {
	private double balance = 90.00;
	private double receiptTotal = 37.45;
	private final double TWENTY_DOLLAR_BILL = 20.00;
	private final double TEN_DOLLAR_BILL = 10.00;
	private final double ONE_DOLLAR_BILL = 1.00;
	private final double QUARTER = 0.25;
	private final double DIME = 0.10;
	private final double NICKEL = 0.05;
	public static void main(String[] args) {

		FarmAnimal[] farmAnimals = new FarmAnimal[]{new Cow(), new Chicken(), new Pig()};

		for (FarmAnimal animal : farmAnimals) {
			String name = animal.getName();
			String sound = animal.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name + ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound + " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		List<Singable> singableList = new ArrayList<>();
		singableList.add(new Tractor());
		singableList.add(new Chicken());
		singableList.add(new Cow());

		for (Singable currentSingable : singableList) {
			System.out.println(currentSingable.getName());

		}

		Tractor tractor = (Tractor) singableList.get(0);
		System.out.println("printing tractor remaining gas " + tractor.remainingGallonsGas());
		//System.out.println("printing singable at index 0 remaining gas" + singableList.get(0).remainingGallonsGas());
		System.out.println(singableList.get(0).getName());





		public String giveChange(double balance){
			double change = balance - receiptTotal;
			balance -= receiptTotal;
			double num20s = change % TWENTY_DOLLAR_BILL;
			change -= num20s * TWENTY_DOLLAR_BILL;
			double num10s = change % TEN_DOLLAR_BILL;
			change -= num10s * TEN_DOLLAR_BILL;


			return num20s + " " + num10s;
		}
	}
}