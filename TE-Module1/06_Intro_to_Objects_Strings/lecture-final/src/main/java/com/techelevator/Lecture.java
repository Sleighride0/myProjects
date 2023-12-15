package com.techelevator;



import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		com.techelevator.example.ExampleClass exampleClass = new com.techelevator.example.ExampleClass();

		JavaBlueStrings jbStr = new JavaBlueStrings();
		System.out.println("Enter a message:");
		String consoleSubmission = scanner.nextLine();
		jbStr.setGivenString(consoleSubmission);
		System.out.println(jbStr.getGivenString());

		JavaBlueStrings javaBStr = new JavaBlueStrings();
		javaBStr.setGivenString("Hey, I'm a new Java Blue String!");




		System.out.println("************************************");
		System.out.println("****** MAKING A STRING OBJECT ******");
		System.out.println("************************************");

		/* The String class gets special treatment in the Java language.  One
		 * example of this is that there is a literal representation of a
		 * String (i.e. characters appearing between two double quotes.  This
		 * is not the case for most classes */

		/* create an new instance of String using a literal */

		String bootcampName = "Tech Elevator";

		System.out.println(bootcampName);

		bootcampName = bootcampName.toUpperCase();

		System.out.println(bootcampName);
		System.out.println(bootcampName);
		System.out.println(bootcampName);
		System.out.println(bootcampName);

		System.out.println();
		System.out.println("******************************");
		System.out.println("****** MEMBER METHODS ******");
		System.out.println("******************************");
		System.out.println();

		String bootName = "TECH ELEVATOR";

		boolean isBootCampStringSame = bootName == bootcampName;
		System.out.println(isBootCampStringSame);

		isBootCampStringSame = bootName.equals(bootcampName);

		System.out.println(isBootCampStringSame);
		/* Other commonly used methods:
		 *
		 * endsWith
		 * startsWith
		 * indexOf
		 * lastIndexOf
		 * length
		 * substring
		 * toLowerCase
		 * toUpperCase
		 * trim
		 */

		System.out.println();
		System.out.println("**********************");
		System.out.println("****** EQUALITY ******");
		System.out.println("**********************");
		System.out.println();

        char[] helloArray = new char[] { 'H', 'e', 'l', 'l', 'o' };
        String hello1 = new String(helloArray);
        String hello2 = new String(helloArray);

		/* Double equals will compare to see if the two variables, hello1 and
		 * hello2 point to the same object in memory. Are they the same object? */
		if (hello1 == hello2) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

		String hello3 = hello1;
		if (hello1 == hello3) {
			System.out.println("hello1 is the same reference as hello3");
		}

		/* So, to compare the values of two objects, we need to use the equals method.
		 * Every object type has an equals method */
		if (hello1.equals(hello2)) {
			System.out.println("They are equal!");
		} else {
			System.out.println(hello1 + " is not equal to " + hello2);
		}

	}
}
