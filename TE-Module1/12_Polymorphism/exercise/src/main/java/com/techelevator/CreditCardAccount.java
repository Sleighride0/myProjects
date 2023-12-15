package com.techelevator;

public class CreditCardAccount implements Accountable {
    @Override
    public int getBalance() {
    return debt * -1;
    }

    private String accountHolderName;
    private String accountNumber;

    private String cardNumber;
    private int debt;


    public CreditCardAccount(String accountHolderName, String cardNumber) {
        this.accountHolderName = accountHolderName;
        this.cardNumber = cardNumber;
    }

   public int pay (int amountToPay){
        if (amountToPay >0) {
            debt = debt - amountToPay;
        } return debt;
    }

   public int charge (int amountToCharge){
        if (amountToCharge >0) {
            debt = debt + amountToCharge;
        } return debt;
    }
    public String getAccountHolderName() {
        return accountHolderName;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public int getDebt() {
        return debt;

    }
}
