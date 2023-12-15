package com.techelevator.quiz;

import com.techelevator.quiz.model.AuthenticatedUser;
import com.techelevator.quiz.model.Question;
import com.techelevator.quiz.model.Quiz;
import com.techelevator.quiz.model.UserCredentials;
import com.techelevator.quiz.services.AuthenticationService;
import com.techelevator.quiz.services.ConsoleService;
import com.techelevator.quiz.services.QuizService;

import java.util.List;

public class App {

    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    private final QuizService quizService = new QuizService(API_BASE_URL);

    private AuthenticatedUser currentUser;

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
        System.out.println("Please register a new user account");
        UserCredentials credentials = consoleService.promptForCredentials();
        if (authenticationService.register(credentials)) {
            System.out.println("Registration successful. You can now login.");
        } else {
            consoleService.printErrorMessage();
        }
    }

    private void handleLogin() {
        UserCredentials credentials = consoleService.promptForCredentials();
        currentUser = authenticationService.login(credentials);
        //have quiz service set the authToken
        quizService.setAuthToken(currentUser.getToken());
        if (currentUser == null) {
            consoleService.printErrorMessage();
        }
    }

    private void mainMenu() {
        int menuSelection = -1;
        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection("Please choose an option: ");
            if (menuSelection == 1) {
                viewRandomQuestion();
            } else if (menuSelection == 2) {
                viewQuizzesByUserCredentials();
            } else if (menuSelection == 3) {
                viewAdminMenu();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

	private void viewRandomQuestion() {
		Question question = quizService.getRandomQuestion();
		consoleService.printMessage(question.getQuestion());
	}

	private void viewQuizzesByUserCredentials() {
		List<Quiz> quizList = quizService.getUserQuizzes();
		consoleService.printQuizzes(quizList);
	}

	private void viewAdminMenu() {
		// TODO Auto-generated method stub
		
	}


}
