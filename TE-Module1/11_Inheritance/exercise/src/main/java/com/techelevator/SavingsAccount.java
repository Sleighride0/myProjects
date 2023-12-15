package com.techelevator;

public class SavingsAccount extends BankAccount{
    private int serviceCharge = 2;

    public SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }

    public SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        int serviceFee = 2;
        if (getBalance() - amountToWithdraw < 2) {
            return getBalance();
        }
        if (getBalance() - amountToWithdraw < 150){
        amountToWithdraw = amountToWithdraw + serviceFee;
        return super.withdraw(amountToWithdraw);
        }
        return super.withdraw(amountToWithdraw);
    }
}
