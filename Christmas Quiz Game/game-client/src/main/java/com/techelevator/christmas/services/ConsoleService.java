package com.techelevator.christmas.services;


import com.techelevator.christmas.model.Question;
import com.techelevator.christmas.model.UserCredentials;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleService {

    private final Scanner scanner = new Scanner(System.in);

    public int promptForMenuSelection(String prompt) {
        int menuSelection;
        System.out.print(prompt);
        try {
            menuSelection = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            menuSelection = -1;
        }
        return menuSelection;
    }

    public void printGreeting() {
        System.out.println("*********************************");
        System.out.println("* Welcome to Christmas Trivia! *");
        System.out.println("*********************************");
    }

    public void printLoginMenu() {
        System.out.println();
        System.out.println("1: Register");
        System.out.println("2: Login");
        System.out.println("0: Exit");
        System.out.println();
    }

    public void printMainMenu() {
        System.out.println();
        System.out.println("1: Take a quiz");
        System.out.println("2: View my high score");
        System.out.println("3: View leaderboard");
        System.out.println("0: Exit");
        System.out.println();
    }
    public void printQuizMenu(){
        System.out.println();
        System.out.println("1: Take Normal Quiz");
        System.out.println("2: Take Hard Quiz");
        System.out.println("0: Return to Main Menu");
    }

    public UserCredentials promptForCredentials() {
        String username = promptForString("Username: ");
        String password = promptForString("Password: ");
        return new UserCredentials(username, password);
    }

    public String promptForString(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public int promptForInt(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number.");
            }
        }
    }

//    public String promptForAnswer(String answer) {
//        System.out.print(answer);
//        return scanner.nextLine();
//    }
    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }
    public void printLoginErrorMessage(){
        System.out.println("Invalid credentials. Please try again.");
    }
    public void printNotAvailableYet() {
        System.out.println("This feature is not available yet.");
    }
    public void printQuestionById(Question question){
        System.out.println("-----------------------------------------------");
        System.out.println("Question: " + question.getQuestionId());
        System.out.println(question.getQuestionPosed());
        System.out.println("(A) " + question.getChoiceA());
        System.out.println("(B) " + question.getChoiceB());
        System.out.println("(C) " + question.getChoiceC());
        System.out.println("(D) " + question.getChoiceD());
    }
     public void printQuizScore(int score){
         System.out.println("Your score was: " + score + " point(s)!");
     }
     public void printHighScore (int score){
         System.out.println("Your high score is: " + score + "!");
     }
}
