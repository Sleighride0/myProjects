package com.techelevator.tenmo.services;


import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.tenmo.model.UserCredentials;

import java.math.BigDecimal;
import java.util.List;
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
        System.out.println("*********************");
        System.out.println("* Welcome to TEnmo! *");
        System.out.println("*********************");
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
        System.out.println("1: View your current balance");
        System.out.println("2: View your past transfers");
        System.out.println("3: View your pending requests");
        System.out.println("4: Send TE bucks");
        System.out.println("5: Request TE bucks");
        System.out.println("0: Exit");
        System.out.println();
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

    public BigDecimal promptForBigDecimal(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                return new BigDecimal(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a decimal number.");
            }
        }
    }

    public void pause() {
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    public void printErrorMessage() {
        System.out.println("An error occurred. Check the log for details.");
    }

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printTransferOptions(){
        System.out.println("1: Approve\n" +
                "2: Reject\n" +
                "0: Don't approve or reject\n" +
                "---------\n");
    }

    public  void printBalance(BigDecimal bigDecimal){
        System.out.println("BALANCE:  $"+bigDecimal.toString());
    }

    public void printUsers(List<User> userList){
        System.out.println("------------------------");
        for(User user : userList){
            System.out.print("User Id: ");
            System.out.println(user.getId());
            System.out.print("Username: ");
            System.out.println(user.getUsername());
            System.out.println("------------------------");
        }
    }

    public void printTransfers(List<Transfer> transferList){
        System.out.println("-----------------------------------------------");
        System.out.println("Transfers");
        System.out.println("ID           From/To                  Amount");
        for(Transfer transfer : transferList){
            String status = "";
            if(transfer.getTransferStatusId() == 1){
                status = "Pending";
            } else if (transfer.getTransferStatusId() == 2) {
                status = "Approved";
            } else {
                status ="Denied";
            }
            String type = "";
            if(transfer.getTransferTypeId()==1){
                type = "Request";
            } else {
                type = "Send";
            }
            System.out.println("FROM : "+transfer.getUserFrom() + "           TO : " +transfer.getUserTo());
            System.out.print("Transfer ID :"+ transfer.getTransferId()+ "  ");
            System.out.println("   Transfer Amount : $"+transfer.getAmount()+ "  ");
            System.out.println("Transfer Status : " + status + "  Transfer Type : "+ type);
            System.out.println("-----------------------------------------------");
        }
    }
    public void printTransferById(Transfer transfer){
        String status = "";
        if(transfer.getTransferStatusId() == 1){
            status = "Pending";
        } else if (transfer.getTransferStatusId() == 2) {
            status = "Approved";
        } else {
            status ="Denied";
        }
        String type = "";
        if(transfer.getTransferTypeId()==1){
            type = "Request";
        } else {
            type = "Send";
        }
        System.out.println("-----------------------------------------------");
        System.out.println("Transfer");
        System.out.println("ID           From/To                  Amount");
        System.out.println("FROM : "+transfer.getUserFrom() + "           TO : " +transfer.getUserTo());
        System.out.print("Transfer ID :"+ transfer.getTransferId()+ "  ");
        System.out.println("   Transfer Amount : $"+transfer.getAmount()+ "  ");
        System.out.println("Transfer Status : " + status + "  Transfer Type : "+ type);
        System.out.println("-----------------------------------------------");
    }
}