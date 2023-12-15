package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class FizzWriter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FizzWriter fizzWriter = new FizzWriter();
		fizzWriter.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("What is the destination file name?: ");
		String fizzPath = userInput.nextLine();
		File DestinationPath = new File(fizzPath);

		try (PrintWriter writer = new PrintWriter(new FileOutputStream(DestinationPath, true)))  {
			for (int i = 1; i < 301; i++) {
				if (i % 3 == 0 && i % 5 == 0){
					writer.println("FizzBuzz");
				}
				else if (i % 3 == 0){
					writer.println("Fizz");
				}
				else if (i % 5 ==0){
					writer.println("Buzz");
				} else {
					writer.println(i);
				}
			}
		} catch (FileNotFoundException e) {
			// Could not find the file at the specified path.
			System.out.println("The file was not found: ");
		}


	}

}
