package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileSplitter {

	// Use this scanner for all user input. Don't create additional Scanners with System.in
	private final Scanner userInput = new Scanner(System.in);

	public static void main(String[] args) {
		FileSplitter fileSplitter = new FileSplitter();
		fileSplitter.run();
	}

	public void run() {
		/* Your code goes here */
		System.out.println("What is the source file?: ");
		String filePath = userInput.nextLine();

		System.out.println("How many lines of text(Max) should there be split in the split files?: ");
		String linesPerSplit = userInput.nextLine();

		int fileCount = 1;
		File sourceFile = new File(filePath);
		File destFile = new File("input-" + fileCount + ".txt");

		////printer does want to be in try with resource, try catch inside while to count fileCount
		try (Scanner inputScanner = new Scanner(sourceFile); ) {

			String currentLine = "";
			//parse from string to int lines
			int linesSplit = Integer.parseInt(linesPerSplit);
			while (inputScanner.hasNextLine()) {
				try (PrintWriter writer = new PrintWriter(destFile)) {
					for (int i = 0; i < linesSplit; i++) {
						if (inputScanner.hasNextLine()) {
							currentLine = inputScanner.nextLine();
							writer.println(currentLine);
						}
					}
					fileCount++;
					destFile = new File("input-" + fileCount + ".txt");
				} catch (FileNotFoundException e) {
					System.out.println("The file was not found: " + sourceFile.getAbsolutePath());
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("The file was not found: " + sourceFile.getAbsolutePath());
		}

	}
}


