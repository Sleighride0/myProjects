package com.techelevator.view;

import com.techelevator.Account;
import com.techelevator.Cart;
import com.techelevator.filereader.InventoryFileReader;
import com.techelevator.filereader.LogFileWriter;
import com.techelevator.items.Item;

import java.util.*;

public class Menu {
    private Scanner scanner = new Scanner(System.in);
    private String choice;
    Account customerAccount = new Account();
    InventoryFileReader ifReader;
    LogFileWriter toLog = new LogFileWriter("log.txt");
    Cart shopping = new Cart();

    public Menu(){
        this.ifReader = new InventoryFileReader();
        ifReader.setFilePath("inventory.csv");
        ifReader.setInventory();
    }
    public void printGreeting() {
        System.out.println("Application is running");
    }

    public void getMainMenu() {
        System.out.println("");
        System.out.println("(1) Show Inventory");
        System.out.println("(2) Make Sale");
        System.out.println("(3) Quit");
        System.out.println("");
        System.out.print("Please select an option: (1) (2) or (3): ");
        this.choice = scanner.nextLine();
        if (this.choice.equals("1")) {
            ifReader.displayInventory();
        }
        else if (this.choice.equals("2")) {
            getSubMenu();
        }
        else if (this.choice.equals("3")) {
            System.out.println("Thank you for shopping!");
            System.exit(0);
        }
        else {
            System.out.println("\nPlease select a valid option: (1) (2) or (3)\n");
        }
    }

    public void getSubMenu() {
        while(true) {
            System.out.println("(1) Take Money");
            System.out.println("(2) Select Products");
            System.out.println("(3) Complete Sale");
            printBalance();
            this.choice = scanner.nextLine();
            if (this.choice.equals("1")) {
                printBalance();
                greet();
                takeMoneyOption();
            } else if (this.choice.equals("2")) {
                ifReader.displayInventory();
                getUserCartSelections();
            } else if (this.choice.equals("3")) {
               checkoutCart();
                System.out.println(":)".repeat(10) + "Thank you for shopping with us today. " + ":)".repeat(10));
//               System.exit(0);
                getMainMenu();
            } else if (this.choice.equals("x")) {
                System.out.println("Press 'x' to exit to the main menu");
                break;
            }
            else {
                System.out.println("\nPlease select a valid option: (1) (2) or (3)\n");
            }
        }
    }

    public void greet() {
        //this greeting appears when the (1)take money is selected
        System.out.println("Thank you for you business.");
        System.out.println("Our machine is capable of holding up to $1000.");
        System.out.println("You can only put in up to $100 at a time. ");
        System.out.println("How much money would you like to enter?");
    }


    public void takeMoneyOption() {
        double before = customerAccount.getBalance();
        int num = 0;
        boolean repeat = false;
        while (true) {
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num > 100) {
                    System.out.println("Sorry at this time we can not accept bills over a $100");
                    System.out.println("Please try again");
                    repeat = true;
                    break;
                }
                if (num + customerAccount.getBalance() > 1000) {
                    System.out.println("Thank you so much for trusting me with $1000 of your money. \nMy " +
                            "spouse will not even do that. \nGood luck getting a refund. You get what you " +
                            "deserve by putting $1000 into a vending machine. \nGOOD LUCK. ");
                    repeat = true;
                    break;
                }

                break;
            } catch (NullPointerException | NumberFormatException exception) {
                System.out.println("You have entered an invalid amount.");
                System.out.println("Please try again");
                repeat = true;
                break;
            }
        }
        if (repeat) {
            takeMoneyOption();
        }
        double after = customerAccount.getBalance();
        String out = toLog.outputFormat("Entered Money" + " $" + num, before, after);
        toLog.writeLog(out);
        customerAccount.deposit(num);
        getSubMenu();
    }

    public void printBalance() {
        System.out.printf("Current Customer Balance: $%.2f" , customerAccount.getBalance());
        System.out.println("");
    }
    public void getUserCartSelections() {
            double before = customerAccount.getBalance();
            System.out.println("Please enter the item Id to purchase or x when finished:");
            String input = scanner.nextLine().toUpperCase();
            if(ifReader.getInventoryMap().containsKey(input)) {
                Item currentItem = ifReader.getInventoryMap().get(input);
                int intInput = userInputInt("Please enter the (number)amount you wish to purchase:");
                if (currentItem.getQuantity() == 0) {
                    System.out.println("This item is sold out. Please try again");
                }
                if (currentItem.getQuantity() < intInput) {
                    System.out.println("There is insufficient stock. Please try again.");
                }
                if ((currentItem.getPrice() * intInput) > customerAccount.getBalance()) {
                    System.out.println("There are insufficient funds. Please try again");
                }
                else {
                    customerAccount.withdraw(currentItem.getPrice() * intInput);
                    currentItem.setQuantity(currentItem.getQuantity() - intInput);
                    for (int i = 0; i < intInput; i++) {
                        shopping.getShoppingCart().add(currentItem);}
                    shopping.currentCart(ifReader.getInventoryMap());
                    double after = customerAccount.getBalance();
                    String out = toLog.outputFormat(intInput + " " + currentItem.getName() + " " +
                            currentItem.getItemID() + " ",  before, after);
                    toLog.writeLog(out);
                }
            }
                else{
                    if(!input.equalsIgnoreCase("x")){
                        System.out.println("The product ID you have entered appears to be incorrect. \n" +
                                "Please try again. ");
                    }
            }
    }
    public void checkoutCart(){
        shopping.currentCart(ifReader.getInventoryMap());
        System.out.printf("Total: $%.2f %n" , shopping.getTotal());
        customerAccount.getChange();

    }
    public int userInputInt(String message) {
        while (true) {
            System.out.println(message);
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NullPointerException | NumberFormatException exception) {
                System.out.println("You have entered an invalid amount.");
                System.out.println("Please try again");
            }
        }
    }
    public void userInputText(String message, List<String> listCheck) {
        System.out.println(message);
        String input = scanner.nextLine().toUpperCase();
        try {
            listCheck.contains(input);
        } catch (NullPointerException | NumberFormatException exception) {
            System.out.println("You have entered an invalid Id.");
            System.out.println("Please try again");
            ifReader.displayInventory();
        }
    }

    public void returnToSub(String nameless) {
        if (choice.equalsIgnoreCase("x")) {
            System.out.println("Please complete Sale when done selecting products");
            getSubMenu();
        }
    }
}
