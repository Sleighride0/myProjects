package com.techelevator;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testInitialBalanceIsZero() {
        assertEquals(0, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositPositiveAmount() {
        account.deposit(50);
        assertEquals(50, account.getBalance(), 0.001);
    }

    @Test
    public void testDepositNegativeAmountDoesNotChangeBalance() {
        account.deposit(-20);
        assertEquals(0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawPositiveAmount() {
        account.deposit(100);
        account.withdraw(30);
        assertEquals(70, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawNegativeAmountDoesNotChangeBalance() {
        account.deposit(100);
        account.withdraw(-30);
        assertEquals(100, account.getBalance(), 0.001);
    }

    @Test
    public void testGetChangeResetsBalance() {
        account.deposit(100);
        account.getChange();
        assertEquals(0, account.getBalance(), 0.001);
    }
}

