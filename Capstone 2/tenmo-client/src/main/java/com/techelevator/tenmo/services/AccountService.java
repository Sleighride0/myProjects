package com.techelevator.tenmo.services;

import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import com.techelevator.util.BasicLogger;
import org.springframework.http.*;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountService {
    private final String BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public AccountService(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public Account getAccountInfo(){
        Account account = null;
        try{
            ResponseEntity<Account> response = restTemplate.exchange(BASE_URL + "accounts", HttpMethod.GET, makeAuthEntity(), Account.class);
            account = response.getBody();
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return account;
    }

    public List<User> getUsers(){
        List<User> allUsers = null;
        try{
            allUsers = Arrays.asList(restTemplate.exchange(BASE_URL + "users", HttpMethod.GET, makeAuthEntity(),
                    User[].class).getBody());
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return allUsers;
    }

    public boolean createTransfer(int transferTypeId, int userFrom, int userTo, BigDecimal amount){
        boolean success = false;

        Transfer transfer = new Transfer();
        transfer.setTransferTypeId(transferTypeId);
        transfer.setUserFrom(userFrom);
        transfer.setUserTo(userTo);
        transfer.setAmount(amount);
        HttpEntity<Transfer> entity = createTransferEntity(transfer);
        try{
            restTemplate.exchange(BASE_URL + "accounts/transfers/send", HttpMethod.POST, entity, Void.class);
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return success;
    }
    public boolean createRequestTransfer(int transferTypeId, int userFrom, int userTo, BigDecimal amount){
        boolean success = false;

        Transfer transfer = new Transfer();
        transfer.setTransferTypeId(transferTypeId);
        transfer.setUserFrom(userFrom);
        transfer.setUserTo(userTo);
        transfer.setAmount(amount);
        HttpEntity<Transfer> entity = createTransferEntity(transfer);
        try{
            restTemplate.exchange(BASE_URL + "accounts/transfers/requests", HttpMethod.POST, entity, Void.class);
            success = true;
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return success;
    }

    public List<Transfer> getUsersTransfers(){
        List<Transfer> userTransfers = new ArrayList<>();
        try{
            userTransfers = Arrays.asList(restTemplate.exchange(BASE_URL + "/accounts/transfers", HttpMethod.GET
                    , makeAuthEntity(),Transfer[].class).getBody());
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return userTransfers;
    }

    public List<Transfer> getUsersPendingTransfers(){
        List<Transfer> userTransfers = new ArrayList<>();
        try{
            userTransfers = Arrays.asList(restTemplate.exchange(BASE_URL + "/accounts/transfers/pending", HttpMethod.GET
                    , makeAuthEntity(),Transfer[].class).getBody());
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return userTransfers;
    }

    public Transfer getTransferById(int id){
        Transfer transfer = new Transfer();
        try{
            transfer = restTemplate.exchange(BASE_URL +"/accounts/transfers/" +id, HttpMethod.GET,
                    makeAuthEntity(), Transfer.class).getBody();
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
        return transfer;
    }
    public void approvePending(int transferId){
        try{
            restTemplate.exchange(BASE_URL + "/accounts/transfers/approve/" + transferId, HttpMethod.PUT,
                    createIntegerEntity(transferId), Integer.class);
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
    }

    public void denyPending(int transferId){
        try{
            restTemplate.exchange(BASE_URL + "/accounts/transfers/deny/" + transferId, HttpMethod.PUT,
                    createIntegerEntity(transferId), Integer.class);
        } catch (RestClientResponseException | ResourceAccessException e){
            BasicLogger.log(e.getMessage());
        }
    }
    private HttpEntity<Integer> createIntegerEntity(int integer){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(integer, headers);
    }
    private HttpEntity<Transfer> createTransferEntity(Transfer transfer){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(transfer, headers);
    }
    private HttpEntity<Void> makeAuthEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);

    }
}
