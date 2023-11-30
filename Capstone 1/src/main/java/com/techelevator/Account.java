package com.techelevator;

public class Account {
    private double balance = 0;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amountToDeposit) {
        if (amountToDeposit > 0 || Double.compare(amountToDeposit,(double)100.00) == 0){
            balance = balance + amountToDeposit;
        }

    }

    public double withdraw(double amountToWithdraw) {
        if (amountToWithdraw > 0) {
            balance = balance - amountToWithdraw;
        }
        return balance;
    }

    public void getChange(){
        double changeToGive = (this.balance);
        double change = this.balance * 100;
//        double[] moneyChange = {20.00, 10.00, 5.0, 1.00, 0.25, 0.10, 0.05, 0.01};
        double[] moneyChange = {2000, 1000, 5000, 100, 25, 10, 5, 1};
        String[] wordChange = {"Twenty", "Ten", "Five", "Dollar", "Quarter", "Dime", "Nickel", "Penny"};
        String[] wordChangePlural = {"Twenties", "Tens", "Fives", "Dollars", "Quarters", "Dimes", "Nickels", "Pennys"};
        String textChange = "";
        int counter = 0;
        while(change >= 0 && counter <= 7){
            int div = (int)(change / moneyChange[counter]);
            if (div > 0){
                if(div == 1){
                    change = Math.round(change - (div * moneyChange[counter]));
                    textChange += "(" + div + ") " + wordChange[counter] + " ";
                }else{
                change = Math.round(change - (div * moneyChange[counter]));
                textChange += "(" + div + ") " + wordChangePlural[counter] + " ";
                }
            }
            counter++;
        }
        System.out.printf("Change: $%.2f %n" ,(changeToGive));
        System.out.println(textChange);
        this.balance = 0;
    }
}
