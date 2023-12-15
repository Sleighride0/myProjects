package com.techelevator;

import java.util.HashMap;
import java.util.Map;

public class Examples {

	/*
	 * Given an array of strings containing Harry Potter characters and their corresponding house,
	 * separated by a comma, return a map where the character is the key and the house is the value.
	 */
	public Map<String,String> hogwartsHouseName(String[] hogwartsRoster) {
		Map<String, String> pottersFriends = new HashMap<>();

		for(String currentString : hogwartsRoster){
			//"Harry Potter,Griffindor"
			//if I split a string based on a character I get back an array with each element pulled from the original string
			String[] arrayFromCurrentString = currentString.split(",");
			//arrayFromCurrentString[0] represents the character
			//arrayFromCurrentString[1] represents the house
			pottersFriends.put(arrayFromCurrentString[0], arrayFromCurrentString[1]);
		}

		return pottersFriends;
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
