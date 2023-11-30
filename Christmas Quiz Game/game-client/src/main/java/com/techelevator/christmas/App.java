package com.techelevator.christmas;

import com.techelevator.christmas.model.AuthenticatedUser;
import com.techelevator.christmas.model.UserCredentials;
import com.techelevator.christmas.services.AuthenticationService;
import com.techelevator.christmas.services.ConsoleService;
import com.techelevator.christmas.services.QuizService;
import org.springframework.web.server.ResponseStatusException;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);
    private final QuizService quizService = new QuizService(API_BASE_URL);

    private AuthenticatedUser currentUser;
    private final int TAKE_QUIZ = 1;
    private final int SEE_MY_HIGH_SCORE = 2;
    private final int SEE_LEADERBOARD = 3;
    private final int TOTAL_AMOUNT_OF_NORMAL_QUESTIONS = 7;
    private String userAnswer;
    private String correctAnswer;

    private int currentScore;

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        consoleService.printGreeting();
        loginMenu();
        if (currentUser != null) {
            mainMenu();
        }
        mainMenu();
    }
    private void loginMenu() {
        int menuSelection = -1;
        while (menuSelection != 0 && currentUser == null) {
            consoleService.printLoginMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                handleRegister();
            } else if (menuSelection == 2) {
                handleLogin();
            } else if (menuSelection != 0) {
                System.out.println("Invalid Selection");
                consoleService.pause();
            }
        }
    }

    private void handleRegister() {
        System.out.println("Please register a new user account. (lowercase only)");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        try {
            UserCredentials credentials = consoleService.promptForCredentials();
            currentUser = authenticationService.login(credentials);
            if (currentUser == null) {
                consoleService.printErrorMessage();
            }
        } catch (Exception e) {
            // Handle invalid credentials
            consoleService.printLoginErrorMessage();
            loginMenu();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == TAKE_QUIZ) {
                SelectQuiz();
                quizService.updateHighScore(currentUser.getUser().getUsername(), currentScore);
                consoleService.printQuizScore(currentScore);
                break;
            } else if (menuSelection == SEE_MY_HIGH_SCORE) {
               consoleService.printHighScore(quizService.getHighScore(currentUser.getUser().getUsername()));
            } else if (menuSelection == SEE_LEADERBOARD) {
              //  viewPendingRequests();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

    public void SelectQuiz(){
        consoleService.printQuizMenu();
        int questionNum = 1;
    int quizChosen = consoleService.promptForInt("Please make a selection: ");
        if(quizChosen == 1){
            currentScore = 0;
            while (questionNum < TOTAL_AMOUNT_OF_NORMAL_QUESTIONS) {
                consoleService.printQuestionById(quizService.getNormalQuestion(questionNum));
                userAnswer = consoleService.promptForString("Please choose (A) (B) (C) or (D):");
                if (userAnswer.equalsIgnoreCase(quizService.getNormalQuestion(questionNum).getCorrectAnswer())){
                currentScore ++;
            }
            questionNum ++;
            }
    } else if (quizChosen == 2){
            consoleService.printNotAvailableYet();
    } else if (quizChosen == 0){
            mainMenu();
    } else {
            consoleService.printErrorMessage();
        }
    }


}
