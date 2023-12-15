package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Examples {

	/*
	 * Given an array of strings containing Harry Potter characters and their corresponding house,
	 * separated by a comma, return a map where the character is the key and the house is the value.
	 */
	public Map<String,String> hogwartsHouseName(String[] hogwartsRoster) {
		Map<String, String> hogwartsNames = new HashMap<>();
		String mapName;
		String mapHouse;
		for (int i = 0; i < hogwartsRoster.length; i++) {
			String[] SplitHog = hogwartsRoster[i].split(",");
			mapName = SplitHog[0];
			mapHouse = SplitHog[1];

			hogwartsNames.put(mapName, mapHouse);
		}



		return hogwartsNames;
	}

	/*
	 * Given a String player, and int representing points earned,  return the players original points increased by the new points.
	 * If the player didn't have an original score on record, return their new score.
	 *
	 * "JAVAGIRL" -> 57500
	 * "INTEGERMAN" -> 54360
	 * "PRGRMNINJA" -> 45300
	 * "ASDFGHJ" -> 34200
	 * "BOB" -> 12980
	 *
	 * The username should be case insensitive
	 *
	 * scoreBoard("javaGirl", 10200) → 67700
	 * scoreBoard("",0) → 0
	 * scoreBoard("BOB",1000) → 13980
	 *
	 */
	public int scoreBoard(String player, int newScore) {
		return 0;
	}




}
