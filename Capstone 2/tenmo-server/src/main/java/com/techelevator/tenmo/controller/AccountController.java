package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.AccountDao;
import com.techelevator.tenmo.dao.TransferDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.security.Principal;
import java.util.List;

@RestController
public class AccountController {
    private final int PENDING_CODE = 1;
    private final int APPROVED_CODE = 2;
    private final int REJECTED_CODE =3;
    private AccountDao accountDao;
    private UserDao userDao;
    private TransferDao transferDao;

    public AccountController(AccountDao accountDao, UserDao userDao, TransferDao transferDao) {
        this.accountDao = accountDao;
        this.userDao = userDao;
        this.transferDao = transferDao;
    }

    @RequestMapping(path = "/accounts", method = RequestMethod.GET)
    public Account getAccountBalance(Principal principal){
        User user = userDao.getUserByUsername(principal.getName());
        return accountDao.getUserAccountInfo(user.getId());
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/accounts/transfers/send", method = RequestMethod.POST)
    public void transferMoney (Principal principal, @Valid @RequestBody Transfer transfer){
      User user = null;
      User userTo = null;
      try {
            user = userDao.getUserByUsername(principal.getName());
            userTo = userDao.getUserById(transfer.getUserTo());
       }catch (NullPointerException e){
           System.out.println("Unauthorized");
       }
        try{
            if(transferDao.increaseAccountBalance(accountDao.getUserAccountInfo(user.getId()), accountDao.getUserAccountInfo(userTo.getId()),transfer.getAmount())){
                transferDao.sendBucks(transfer);
            }
        } catch (ResourceAccessException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/accounts/transfers/requests", method = RequestMethod.POST)
    public void requestMoney (Principal principal, @Valid @RequestBody Transfer transfer){
        User userTo = null;
        User userFrom = null;
        try {
            userTo = userDao.getUserByUsername(principal.getName());
            userFrom = userDao.getUserById(transfer.getUserFrom());
            transfer.setUserTo(userTo.getId());
            transfer.setUserFrom(userFrom.getId());
        }catch (NullPointerException e){
            System.out.println("Unauthorized");
        }
        try{
            if (userFrom.getId() == userTo.getId()) {
                throw new DaoException("You cannot send/get money to yourself.");
            }
            if(transfer.getAmount().compareTo(BigDecimal.ZERO)<=0){
                throw new DaoException("You cannot send/get a negative or zero amount.");
            } else {
                transferDao.requestBucks(transfer);
            }
        } catch (ResourceAccessException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/accounts/transfers/approve/{transferId}", method = RequestMethod.PUT)
    public void approveRequest (Principal principal, @Valid @PathVariable int transferId){
        User userTo = null;
        User userFrom = null;
        Transfer transfer = null;
        try {
            userFrom = userDao.getUserByUsername(principal.getName());
            transfer = transferDao.getPendingTransferById(transferId, accountDao.getUserAccountInfo(userFrom.getId()).getAccountId());
            userTo = userDao.getUserById(transfer.getUserTo());
        }catch (NullPointerException e){
            System.out.println("Unauthorized");
        }
        try{
            if (transfer.getTransferStatusId()==PENDING_CODE) {
                if (transferDao.increaseAccountBalance(accountDao.getUserAccountInfo(userFrom.getId()),
                        accountDao.getUserAccountInfo(userTo.getId()), transfer.getAmount())) {
                    transferDao.updateTransfer(transferId, APPROVED_CODE);
                }
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        } catch (ResourceAccessException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path = "/accounts/transfers/deny/{transferId}", method = RequestMethod.PUT)
    public void DenyRequest (Principal principal, @Valid @PathVariable int transferId){
        Transfer transfer = null;
        User user = userDao.getUserByUsername(principal.getName());
        try{
            transfer = transferDao.getPendingTransferById(transferId, accountDao.getUserAccountInfo(user.getId()).getAccountId());
            if (transfer.getTransferStatusId()==PENDING_CODE) {
                transferDao.updateTransfer(transferId, REJECTED_CODE);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        } catch (NullPointerException e) {
            System.out.println("Unauthorized");
        }
    }
    @RequestMapping(path = "/accounts/transfers", method = RequestMethod.GET)
    public List<Transfer> getUserTransfers(Principal principal){
        User user = userDao.getUserByUsername(principal.getName());
        return transferDao.getListTransfersById(accountDao.getUserAccountInfo(user.getId()).getAccountId());
    }

    @RequestMapping(path = "/accounts/transfers/pending", method = RequestMethod.GET)
    public List<Transfer> getPendingUserTransfers(Principal principal){
        User user = userDao.getUserByUsername(principal.getName());
        return transferDao.getPendingListTransfersById(accountDao.getUserAccountInfo(user.getId()).getAccountId());
    }

    @RequestMapping(path = "/accounts/transfers/{transferId}", method = RequestMethod.GET)
    public Transfer getTransferById(Principal principal,@Valid @PathVariable int transferId){
        User user = userDao.getUserByUsername(principal.getName());
        return transferDao.getTransferById(transferId,accountDao.getUserAccountInfo(user.getId()).getAccountId());
    }

    @RequestMapping(path = "/users", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userDao.getUsers();
    }
}
