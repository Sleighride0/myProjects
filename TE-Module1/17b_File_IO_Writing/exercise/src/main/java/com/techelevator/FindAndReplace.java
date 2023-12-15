package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FindAndReplace {

    // Use this scanner for all user input. Don't create additional Scanners with System.in
    private final Scanner userInput = new Scanner(System.in);

    public static void main(String[] args) {
        FindAndReplace findAndReplace = new FindAndReplace();
        findAndReplace.run();
    }

    public void run() {
        /* Your code goes here */
        System.out.print("What is the search word?: ");
        String searchWord = userInput.nextLine();

        System.out.println("What is the replacement word?: ");
        String  replaceWord = userInput.nextLine();

        System.out.println("What is the source file?: ");
        String filePath = userInput.nextLine();

        System.out.println("What is the destination file?: ");
        String destPath = userInput.nextLine();

        File bookFile = new File(filePath);
        File destFile = new File(destPath);

        try(Scanner inputScanner = new Scanner(bookFile); PrintWriter writer = new PrintWriter(destFile)) {
            while (inputScanner.hasNextLine()) {
                String currentLine = inputScanner.nextLine();
                if (currentLine.contains(searchWord)) {
                    currentLine = currentLine.replaceAll(searchWord, replaceWord);
                    // original mistake was only printing the line containing searchWord and not all lines.
                }
                writer.println(currentLine);
            }
        } catch (FileNotFoundException e) {
            // Could not find the file at the specified path.
            System.out.println("The file was not found: " + bookFile.getAbsolutePath());
        }


    }

}
