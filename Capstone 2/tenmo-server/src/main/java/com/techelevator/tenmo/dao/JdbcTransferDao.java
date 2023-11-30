package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Account;
import com.techelevator.tenmo.model.Transfer;
import com.techelevator.tenmo.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;

import javax.sql.DataSource;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcTransferDao implements TransferDao{
    private final int PENDING_CODE = 1;
    private final int APPROVED_CODE = 2;
    private final int REJECTED_CODE =3;
    private final int REQUEST_TRANSFER_CODE = 1;
    private final int SEND_TRANSFER_CODE = 2;

    private JdbcTemplate jdbcTemplate;
    private UserDao userdao;
    private AccountDao accountDao;
    public JdbcTransferDao (DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Transfer sendBucks(Transfer transfer) {
            transfer.setTransferStatusId(APPROVED_CODE);
            transfer.setTransferTypeId(SEND_TRANSFER_CODE);
            Transfer newTransfer = transfer;
            int userFrom =0;
            int userTo =0;
            String sqlOne = "SELECT account_id FROM account WHERE user_id = ?;";

            SqlRowSet resultsFrom = jdbcTemplate.queryForRowSet(sqlOne, transfer.getUserFrom());
            while(resultsFrom.next()){
                userFrom = resultsFrom.getInt("account_id");
            }
            SqlRowSet resultsTo = jdbcTemplate.queryForRowSet(sqlOne, transfer.getUserTo());
            while(resultsTo.next()) {
                userTo = resultsTo.getInt("account_id");
            }
            String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount)\n" +
                    "VALUES (?,?,?,?,?) RETURNING transfer_id;";

            int transferId = jdbcTemplate.queryForObject(sql, int.class,transfer.getTransferTypeId(),transfer.getTransferStatusId(),
                    userFrom, userTo, transfer.getAmount());
            newTransfer.setTransferId(transferId);

            return newTransfer;
        }

    public Transfer requestBucks(Transfer transfer) {
        transfer.setTransferStatusId(PENDING_CODE);
        transfer.setTransferTypeId(REQUEST_TRANSFER_CODE);
        Transfer newTransfer = transfer;
        int userFrom =0;
        int userTo =0;
        String sqlOne = "SELECT account_id FROM account WHERE user_id = ?;";

        SqlRowSet resultsFrom = jdbcTemplate.queryForRowSet(sqlOne, transfer.getUserFrom());
        while(resultsFrom.next()){
            userFrom = resultsFrom.getInt("account_id");
        }
        SqlRowSet resultsTo = jdbcTemplate.queryForRowSet(sqlOne, transfer.getUserTo());
        while(resultsTo.next()) {
            userTo = resultsTo.getInt("account_id");
        }
        String sql = "INSERT INTO transfer (transfer_type_id, transfer_status_id, account_from, account_to, amount)\n" +
                "VALUES (?,?,?,?,?) RETURNING transfer_id;";

        int transferId = jdbcTemplate.queryForObject(sql, int.class,transfer.getTransferTypeId(),transfer.getTransferStatusId(),
                userFrom, userTo, transfer.getAmount());
        newTransfer.setTransferId(transferId);

        return newTransfer;
    }


    public boolean increaseAccountBalance(Account accountFrom, Account accountTo, BigDecimal transferAmount){
        boolean success = false;
        try{
            if (accountFrom.getUserId() == accountTo.getUserId()) {
                throw new DaoException("You cannot send/get money to yourself.");
            } else {
                if (accountFrom.getBalance().compareTo(transferAmount) >= 0) {
                    if(transferAmount.compareTo(BigDecimal.ZERO)<=0){
                        throw new DaoException("You cannot send/get a negative or zero amount.");
                    } else {
                        accountFrom.setBalance(accountFrom.getBalance().subtract(transferAmount));
                        accountTo.setBalance(accountTo.getBalance().add(transferAmount));

                        String sql = "UPDATE account SET balance = ? WHERE user_id = ?;";
                        int numberOfRows = jdbcTemplate.update(sql, accountFrom.getBalance(), accountFrom.getUserId());
                        int numberofRowsTwo = jdbcTemplate.update(sql, accountTo.getBalance(), accountTo.getUserId());
                        success = true;
                    }
                }else{
                    throw new DaoException("You don't have enough money.");
                }
            }

        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return success;
    }

    public List<Transfer> getListTransfersById(int accountId){
        List<Transfer> holdList = new ArrayList<>();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to,\n" +
                " amount FROM transfer WHERE account_from = ? OR account_to = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,accountId,accountId);
        while(results.next()){
            Transfer transfer = mapRowToTransfer(results);
            holdList.add(transfer);
        }
        return holdList;
    }
    public List<Transfer> getPendingListTransfersById(int accountId){
        List<Transfer> holdList = new ArrayList<>();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to,\n" +
                " amount FROM transfer WHERE transfer_status_id = 1 AND account_from = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,accountId);
        while(results.next()){
            Transfer transfer = mapRowToTransfer(results);
            holdList.add(transfer);
        }
        return holdList;
    }
    public Transfer getTransferById(int transferId, int userId){
        Transfer transfer = new Transfer();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to,\n" +
                " amount FROM transfer WHERE transfer_id = ? AND (account_from = ? OR account_to = ?);";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId, userId, userId);
        while(results.next()){
            transfer = mapRowToTransfer(results);
        }
        if(transfer.getAmount() == null){
            throw new DaoException("Unauthorized.");
        }
        return transfer;
    }
    public Transfer getPendingTransferById(int transferId, int userId){
        Transfer transfer = new Transfer();
        String sql = "SELECT transfer_id, transfer_type_id, transfer_status_id, account_from, account_to,\n" +
                " amount FROM transfer WHERE transfer_id = ? AND account_from = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, transferId, userId);
        while(results.next()){
            transfer = mapRowToTransfer(results);
        }
        if(transfer.getAmount() == null){
            throw new DaoException("Unauthorized.");
        }
        return transfer;
    }

    public boolean updateTransfer(int transferId, int statusCode){
        boolean success = false;
        String sql = "UPDATE transfer SET transfer_status_id = ? WHERE transfer_id = ?;";

        try{
            int numberOfRows = jdbcTemplate.update(sql, statusCode, transferId);
            if (numberOfRows == 0) {
                throw new DaoException("Zero rows affected, expected at least one");
            } else {
                success = true;
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }

        return success;
    }

    public Transfer mapRowToTransfer(SqlRowSet results){
        int userFrom = 0;
        int userTo = 0;
        Transfer transfer = new Transfer();
        transfer.setTransferId(results.getInt("transfer_id"));
        transfer.setTransferTypeId(results.getInt("transfer_type_id"));
        transfer.setTransferStatusId(results.getInt("transfer_status_id"));
        String sql = "SELECT user_id FROM account WHERE account_id = ?;";
        SqlRowSet resultsUserFrom = jdbcTemplate.queryForRowSet(sql, results.getInt("account_from"));
        while(resultsUserFrom.next()){
            userFrom = resultsUserFrom.getInt("user_id");
        }
        transfer.setUserFrom(userFrom);
        SqlRowSet resultsUserTo = jdbcTemplate.queryForRowSet(sql, results.getInt("account_to"));
        while(resultsUserTo.next()){
            userTo = resultsUserTo.getInt("user_id");
        }
        transfer.setUserTo(userTo);
        transfer.setAmount(results.getBigDecimal("amount"));
        return transfer;

    }
}