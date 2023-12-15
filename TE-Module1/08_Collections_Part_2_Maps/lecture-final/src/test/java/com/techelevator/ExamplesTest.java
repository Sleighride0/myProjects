package com.techelevator;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ExamplesTest {


	Examples examples = new Examples();

	/*
	 Given an array of strings containing Harry Potter characters and their corresponding house,
	 * separated by a comma, return a map where the character is the key and the house is the value.
	 *
	 */
	@Test
	public void example01_hogwartsHouseName() {
		Map<String, String> output = examples.hogwartsHouseName(new String[] { "Harry Potter,Gryffindor", "Hermione Granger,Gryffindor","Ron Weasley,Gryffindor","Draco Malfoy,Slytherin","Severus Snape,Slytherin" });
		assertThat( output, hasEntry("Hermione Granger", "Gryffindor"));
		assertThat( output, hasEntry("Draco Malfoy", "Slytherin"));
		assertThat( output, hasEntry("Harry Potter", "Gryffindor"));
		assertThat( output, hasEntry("Ron Weasley", "Gryffindor"));
		assertThat( output, hasEntry("Severus Snape", "Slytherin"));
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
	@Test
	public void exercise02_scoreBoard() {
		assertEquals( 67700, examples.scoreBoard("javaGirl",10200));
		assertEquals(13980, examples.scoreBoard("BOB",1000));
		assertEquals(0, examples.scoreBoard("",0));
	}


}
