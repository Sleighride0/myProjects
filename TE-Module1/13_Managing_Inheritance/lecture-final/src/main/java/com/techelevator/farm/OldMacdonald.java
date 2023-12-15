package com.techelevator.farm;

public class OldMacdonald {
	public static void main(String[] args) {

		FarmAnimal animal = new Chicken();

		Cow bessie = new Cow();
		bessie.setAsleep(true);

		Pig wilbur = new Pig();

		Cat cheshireCat = new Cat();
		cheshireCat.setAsleep(true);

		Singable[] singables =
				new Singable[] {bessie, new Cow(), new Chicken(), new Pig(), new Tractor(), wilbur, new Cat(), cheshireCat};

		wilbur.setAsleep(true);

		for (Singable singable : singables) {
			String name = singable.getName();
			String sound = singable.getSound();
			System.out.println("Old MacDonald had a farm, ee, ay, ee, ay, oh!");
			System.out.println("And on his farm he had a " + name
					+ ", ee, ay, ee, ay, oh!");
			System.out.println("With a " + sound + " " + sound + " here");
			System.out.println("And a " + sound + " " + sound + " there");
			System.out.println("Here a " + sound + " there a " + sound
					+ " everywhere a " + sound + " " + sound);
			System.out.println();
		}

		Sellable[] sellables = new Sellable[] {new Cow(), new Pig(), new Egg()};

		for (Sellable sellable : sellables) {
			System.out.println("Step right up and get your " + sellable.getName());
			System.out.println("Only $" + sellable.getPrice());
		}

		System.out.println(bessie);
	}
}