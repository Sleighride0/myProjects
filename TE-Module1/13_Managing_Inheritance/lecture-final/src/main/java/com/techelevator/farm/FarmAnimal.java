package com.techelevator.farm;

public abstract class FarmAnimal implements Singable {
	private String name;
	private String sound;
	protected boolean isAsleep;

	public FarmAnimal(String name, String sound) {
		this.name = name;
		this.sound = sound;
	}

	protected abstract String eat();
	public String getName( ) {
		return name;
	}
	public final String getSound( ) {
		if(isAsleep){
			return "ZZzzzzz.....";
		}
		return sound;
	}

	void setAsleep(boolean asleep) {
		isAsleep = asleep;
	}
}