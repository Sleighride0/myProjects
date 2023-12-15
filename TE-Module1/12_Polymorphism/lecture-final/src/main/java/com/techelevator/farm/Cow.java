package com.techelevator.farm;

public class Cow extends FarmAnimal {

	public Cow() {
		super("Cow", "moo!");
	}

	@Override
	public String getSound() {

		return super.getSound() + "\n" +
				" ^__^\n" +
				" (oo)\\_______\n" +
				" (__)\\       )\\/\\\n" +
				"     ||----w |\n" +
				"     ||     ||\n";
	}
}