package com.techelevator.tenmo;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.AuthenticatedUser;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.UserCredentials;
import com.techelevator.tenmo.services.AccountService;
import com.techelevator.tenmo.services.AuthenticationService;
import com.techelevator.tenmo.services.ConsoleService;

import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

public class App {

    private final int REQUEST_TRANSFER_CODE = 1;
    private final int SEND_TRANSFER_CODE = 2;
    private static final String API_BASE_URL = "http://localhost:8080/";

    private final ConsoleService consoleService = new ConsoleService();
    private final AuthenticationService authenticationService = new AuthenticationService(API_BASE_URL);

    private final AccountService accountService = new AccountService(API_BASE_URL);

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
        accountService.setAuthToken(currentUser.getToken());
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
                viewCurrentBalance();
            } else if (menuSelection == 2) {
                viewTransferHistory();
            } else if (menuSelection == 3) {
                viewPendingRequests();
            } else if (menuSelection == 4) {
                sendBucks();
            } else if (menuSelection == 5) {
                requestBucks();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

	private void viewCurrentBalance() {
        Account account = accountService.getAccountInfo();
        consoleService.printBalance(account.getBalance());
	}

	private void viewTransferHistory() {
        int transferIdChosen = consoleService.promptForInt("Please enter the ID of a Transfer or 0 for all history: ");
        if(transferIdChosen == 0){
            consoleService.printTransfers(accountService.getUsersTransfers());
        } else {
            Transfer transfer = accountService.getTransferById(transferIdChosen);
            if (transfer.getAmount()!=null){
                consoleService.printTransferById(transfer);
            } else {
                consoleService.printErrorMessage();
            }
        }
	}

    private void viewTransferById(){

    }

	private void viewPendingRequests() {
        while (true) {
            consoleService.printTransfers(accountService.getUsersPendingTransfers());
            int transferIdChosen = consoleService.promptForInt("Please enter transfer ID to approve/reject (0 to cancel): ");
            if(transferIdChosen==0){
                break;
            }
            consoleService.printTransferOptions();
            int optionChosen = consoleService.promptForInt("Please choose an option:");
            if(optionChosen == 1){
                accountService.approvePending(transferIdChosen);
            } else if (optionChosen==2) {
                accountService.denyPending(transferIdChosen);
            }
            break;
        }
        
	}

	private void sendBucks() {
        while(true){
            consoleService.printUsers(accountService.getUsers());
            int userIdChosen = consoleService.promptForInt("Please type a User Id (numbers only): ");
            if (currentUser.getUser().getId() == userIdChosen) {
                System.out.println("You cannot send money to yourself!");
                break;
            }

            BigDecimal amountChosen = consoleService.promptForBigDecimal("Please type a decimal amount to send: ");
            if(accountService.getAccountInfo().getBalance().compareTo(amountChosen)<0){
                System.out.println("You do not have enough money!");
                break;
            }
            if(amountChosen.compareTo(BigDecimal.ZERO)<=0){
                System.out.println("You cannot send a negative amount!");
                break;
            }
            if(accountService.createTransfer(SEND_TRANSFER_CODE, accountService.getAccountInfo().getUserId(), userIdChosen, amountChosen)){
                System.out.println("Transfer sent.");
                break;
            }
            System.out.println("An error has occurred. Please try again.");
            break;
        }
	}

	private void requestBucks() {
		while(true){
            consoleService.printUsers(accountService.getUsers());
            int userIdChosen = consoleService.promptForInt("Please type a User Id (numbers only): ");
            if (currentUser.getUser().getId() == userIdChosen) {
                System.out.println("You cannot request money from yourself!");
                break;
            }

            BigDecimal amountChosen = consoleService.promptForBigDecimal("Please type a decimal amount to request: ");
            if(amountChosen.compareTo(BigDecimal.ZERO)<=0){
                System.out.println("You cannot request a negative or zero amount!");
                break;
            }
            if(accountService.createRequestTransfer(REQUEST_TRANSFER_CODE, userIdChosen,accountService.getAccountInfo().getUserId(), amountChosen )){
                System.out.println("Transfer request sent.");
                break;
            }
            System.out.println("An error has occurred. Please try again.");
            break;
        }
		
	}

}
