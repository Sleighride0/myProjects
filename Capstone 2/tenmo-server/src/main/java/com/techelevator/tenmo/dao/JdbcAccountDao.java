package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Account;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.math.BigDecimal;
@Component
public class JdbcAccountDao implements AccountDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcAccountDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Account getUserAccountInfo(int userId) {
        Account account = null;
        String sql = "SELECT * FROM account WHERE user_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()){
            account = mapToAccount(results);
        }
        return account;
    }

    public Account mapToAccount(SqlRowSet results){
        Account account = new Account();
        account.setUserId(results.getInt("user_id"));
        account.setAccountId(results.getInt("account_id"));
        account.setBalance(results.getBigDecimal("balance"));
        return account;
    }
}
