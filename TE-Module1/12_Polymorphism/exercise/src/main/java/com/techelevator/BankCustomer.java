package com.techelevator;

import java.util.List;

public class BankCustomer {
    private String name;
    private String address;
    private String phoneNumber;

    private List<Accountable> accounts;




    public Accountable[] getAccounts() {
        Accountable[] accountArray = new Accountable[accounts.size()];
        return accounts.toArray(accountArray);
    }
    public void addAccount (Accountable newAccount){
        accounts.add(newAccount);
    }
    public boolean isVip(){
        int vipMoneyMark = 0;
        for (Accountable current: accounts) {
            vipMoneyMark += current.getBalance();
        }
        if (vipMoneyMark >= 25000){
            return true;
        } return false;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
