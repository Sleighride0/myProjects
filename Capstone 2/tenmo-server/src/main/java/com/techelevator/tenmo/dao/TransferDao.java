package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;

import java.math.BigDecimal;
import java.util.List;

public interface TransferDao {



    public Transfer sendBucks(Transfer transfer);
    public boolean increaseAccountBalance(Account accountFrom, Account accountTo, BigDecimal transferAmount);
    public List<Transfer> getListTransfersById(int accountId);
    public Transfer getTransferById(int transferId, int userId);
    public Transfer requestBucks(Transfer transfer);
    public List<Transfer> getPendingListTransfersById(int accountId);
    public Transfer getPendingTransferById(int transferId, int userId);
    public boolean updateTransfer(int transferId, int statusCode);





}


