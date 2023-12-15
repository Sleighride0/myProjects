package com.techelevator.farm;

public class Chicken extends FarmAnimal {

	public Chicken() {
		super("Chicken", "cluck!");
	}


	public void layEgg() {
		System.out.println("Chicken laid an egg!");
	}

	@Override
	public String getSound() {

		return super.getSound() + "\n" +
	"  __//\n"+
    "/@   @\\"+"\n"+
   "\\  <  /" +"\n"+
   "/   °  \\ / /" + "\n"+
   "\\      / //" + "\n"+
   " \\____/"+"\n"+
	"___|_|____"+
	"	\" \"";
	}
}