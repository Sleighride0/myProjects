package com.techelevator;

public class CheckingAccount extends BankAccount {


    public CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    public CheckingAccount (String accountHolderName, String accountNumber, int balance){
        super(accountHolderName, accountNumber, balance);
    }
    @Override
    public int withdraw(int amountToWithdraw) {
        int withdrawFee = 10;
        if (getBalance() - amountToWithdraw <= -100) {
            return getBalance();
        }
        if ((getBalance() - amountToWithdraw < 0) && (getBalance() - amountToWithdraw > -100)) {
            amountToWithdraw = amountToWithdraw + withdrawFee;
            return super.withdraw(amountToWithdraw);
        }

        return super.withdraw(amountToWithdraw);
        }
        //reassign amount to withdraw based on fees
        //do some step into checks to help me understand

}

