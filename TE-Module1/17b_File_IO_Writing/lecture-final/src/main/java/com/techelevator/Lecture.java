package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lecture {

	public static void main(String[] args) throws IOException {

		Scanner userInput = new Scanner(System.in);

		/*
		 * The java.io.File class is a representation of file and directory path names.  It provides methods to inspect and
		 * modify file system objects.
		 *
		 * One benefit is that it compensates for differences in Windows and Unix use of '/' and '\' as directory delimiters.
		 *
		 * A new instance of File can be created from a String that contains a file system path
		 */

		File file = new File("PeterPan.txt");

		File mittensJournal = new File("mittenJournal.txt");

		System.out.println(file.getAbsolutePath());
		if (file.exists()) {
			System.out.println("the file exists");
		}

		try (Scanner inputScanner = new Scanner(file); PrintWriter writer = new PrintWriter(mittensJournal)) {
			int lineNumber = 1;
			while (inputScanner.hasNextLine()) {
				String currentLine = inputScanner.nextLine();
				if (currentLine.contains("Hook")) {
					writer.println(lineNumber + ") " + currentLine.replaceAll("Hook", "Glove"));
					System.out.println(lineNumber + ") " + currentLine.replaceAll("Hook", "Mittens"));
				}

				lineNumber++;
			}
		} catch(FileNotFoundException e){
			System.out.println(file.getName() + " was not found");
			System.out.println(e.getMessage());
		}
	}

}
