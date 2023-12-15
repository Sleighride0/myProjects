package com.techelevator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lecture {

	public static void main(String[] args) {
		System.out.println("####################");
		System.out.println("       LISTS");
		System.out.println("####################");
		List<String> javaBlue = new ArrayList<>();
		javaBlue.add("Anisa");
		javaBlue.add("Jack");
		javaBlue.add("Kayla");

		System.out.println(javaBlue);

		System.out.println("####################");
		System.out.println("Lists are ordered");
		System.out.println("####################");

		for(int i = 0; i < javaBlue.size(); i++){
			System.out.println("Welcome " + javaBlue.get(i));
		}

		System.out.println("####################");
		System.out.println("Lists allow duplicates");
		System.out.println("####################");

		javaBlue.add("Kayla");
		System.out.println(javaBlue);

		System.out.println("####################");
		System.out.println("Lists allow elements to be inserted in the middle");
		System.out.println("####################");

		javaBlue.add(javaBlue.size()/2, "Leul");
		System.out.println(javaBlue);

		String temp = javaBlue.get(0);
		String temp1 = javaBlue.get(1);
		javaBlue.remove(0);
		javaBlue.add(0, temp1);
		javaBlue.remove(1);


		javaBlue.add(1,temp);

		System.out.println(javaBlue);

		System.out.println("####################");
		System.out.println("Lists allow elements to be removed by index");
		System.out.println("####################");


		System.out.println("####################");
		System.out.println("Find out if something is already in the List");
		System.out.println("####################");
		int countOfKaylas = 0;
		for(String currentStringFromJavaBlue : javaBlue){
			if(currentStringFromJavaBlue.equals("Kayla")){
				System.out.println("We found her!");
				countOfKaylas++;
			}
			if(javaBlue.contains("Faduma")){
				System.out.println("We found her too!");
			}
		}

		System.out.println("We found " + countOfKaylas + " Kaylas");


		System.out.println("####################");
		System.out.println("Find index of item in List");
		System.out.println("####################");
		System.out.println(javaBlue);
		System.out.println(javaBlue.indexOf("Kayla"));

		System.out.println("####################");
		System.out.println("Lists can be turned into an array");
		System.out.println("####################");

//		String[] arrayOfJavaBlue = javaBlue.toArray(new String[javaBlue.size()]);

		javaBlue.add(5, "Abdul");

		System.out.println(javaBlue);

		System.out.println("####################");
		System.out.println("Lists can be sorted");
		System.out.println("####################");

		Collections.sort(javaBlue);
		System.out.println(javaBlue);
		System.out.println(javaBlue);

		System.out.println("####################");
		System.out.println("Lists can be reversed too");
		System.out.println("####################");

		Collections.reverse(javaBlue);
		System.out.println(javaBlue);
		System.out.println(javaBlue);
		System.out.println("####################");
		System.out.println("       FOREACH");
		System.out.println("####################");
		System.out.println();

		Integer ex = new Integer(8);
	}
}
