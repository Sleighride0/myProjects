package org.example;

public class Main {

    private Menu menu = new Menu();
    private Account account = new Account();
    public static void main(String[] args) {

    }
    public void run() {

        menu.getMainMenu();
        account.giveChange(90.00);
       account.getBalance();
    }
}