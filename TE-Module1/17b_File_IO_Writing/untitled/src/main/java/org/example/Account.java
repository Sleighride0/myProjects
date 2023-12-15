package org.example;

public class Account {

    private double balance;
    private double receiptTotal;
    private final double TWENTY_DOLLAR_BILL = 20.00;
    private final double TEN_DOLLAR_BILL = 10.00;
    private final double ONE_DOLLAR_BILL = 1.00;
    private final double QUARTER = 0.25;
    private final double DIME = 0.10;
    private final double NICKEL = 0.05;

    Account(){
        this.balance = balance;
        this.receiptTotal = receiptTotal;

    }
    public String giveChange(double balance){
        double change = balance - receiptTotal;
        balance -= receiptTotal;
        double num20s = change % TWENTY_DOLLAR_BILL;
        change -= num20s * TWENTY_DOLLAR_BILL;
        double num10s = change % TEN_DOLLAR_BILL;
        change -= num10s * TEN_DOLLAR_BILL;


        return num20s + " " + num10s;
    }




    public double getBalance() {
        return balance;
    }


}
