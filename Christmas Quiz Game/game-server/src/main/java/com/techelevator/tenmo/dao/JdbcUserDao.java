package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.RegisterUserDto;
import com.techelevator.tenmo.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcUserDao implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User getUserById(int userId) {
        User user = null;
        String sql = "SELECT user_id, username, password_hash FROM game_user WHERE user_id = ?";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
            if (results.next()) {
                user = mapRowToUser(results);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT user_id, username, password_hash FROM game_user";
        try {
            SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
            while (results.next()) {
                User user = mapRowToUser(results);
                users.add(user);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return users;
    }

    @Override
    public User getUserByUsername(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");
        User user = null;
        String sql = "SELECT user_id, username, password_hash FROM game_user WHERE username = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
            if (rowSet.next()) {
                user = mapRowToUser(rowSet);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        //problem was username to lowercase when making an uppercase username
        return user;
    }

    @Override
    public User createUser(RegisterUserDto user) {
        User newUser = null;
        // create user
        String sql = "INSERT INTO game_user (username, password_hash) VALUES (?, ?) RETURNING user_id";
        String password_hash = new BCryptPasswordEncoder().encode(user.getPassword());
        try {
            int newUserId = jdbcTemplate.queryForObject(sql, int.class, user.getUsername(), password_hash);
            newUser = getUserById(newUserId);
//            if (newUser != null) {
//                // create account
//                sql = "INSERT INTO account (user_id, balance) VALUES (?, ?)";
//                jdbcTemplate.update(sql, newUserId, STARTING_BALANCE);
//            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        } catch (DataIntegrityViolationException e) {
            throw new DaoException("Data integrity violation", e);
        }
        return newUser;
    }

//    public int getUserHighScore(String username) {
//        if (username == null) throw new IllegalArgumentException("Username cannot be null");
//        int highScore = 0;
//        String sql = "SELECT normal_quiz_high_score FROM game_user WHERE username = ?;";
//            try {
//                SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
//                if (rowSet.next()) {
//                    highScore = rowSet.getInt("normal_quiz_high_score");
//                }
//            } catch (CannotGetJdbcConnectionException e) {
//                throw new DaoException("Unable to connect to server or database", e);
//            }
//        return highScore;
//    }

    private User mapRowToUser(SqlRowSet rs) {
        User user = new User();
        user.setId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
       // user.setNormalHighScore(rs.getInt("normal_quiz_high_score"));
        //user.setHardHighScore(rs.getInt("hard_quiz_high_score"));
        user.setActivated(true);
        user.setAuthorities("USER");
        return user;
    }
}
