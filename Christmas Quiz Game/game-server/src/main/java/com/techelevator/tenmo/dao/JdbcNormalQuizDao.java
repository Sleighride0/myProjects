package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.exception.DaoException;
import com.techelevator.tenmo.model.Question;
import com.techelevator.tenmo.model.User;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcNormalQuizDao implements QuizDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcNormalQuizDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    /* Notes: Need to check for best approach with using getnormalquestions versus getting normalquiz vs hardquiz*/

    public Question getNormalQuizQuestion (int questionId){
        Question question = null;
        String sql = "SELECT question_id, question_posed, option_a, option_b, option_c, option_d, correct_answer FROM question\n" +
                "WHERE question_id IN (SELECT question_id FROM quiz_question WHERE quiz_id = 1) AND question_id = ?;";
        //will this work if i don't ask for the answer? i want that hidden from the user
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, questionId);
        if(results.next()){
            question = mapRowToQuestion(results);
            //call updateQuestionAskedStatus()
        } //else call resetQuestionAsked()
        return question;
    }

    public List<Question> getNormalQuiz (){
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT question_id, question_posed, option_a, option_b, option_c, option_d, correct_answer FROM question\n" +
                "WHERE question_id IN (SELECT question_id FROM quiz_question WHERE quiz_id = 1)";
        //will this work if i dont ask for the answer? i want that hidden from the user
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Question question = mapRowToQuestion(results);
            questions.add(question);
        }
        return questions;
    }
    public List<Question> getHardQuiz (){
        List<Question> questions = new ArrayList<>();
        String sql = "SELECT question_id, question_posed, option_a, option_b, option_c, option_d, correct_answer FROM question\n" +
                "WHERE question_id IN (SELECT question_id FROM quiz_question WHERE quiz_id = 2)";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()){
            Question question = mapRowToQuestion(results);
            questions.add(question);
        }
        return questions;
    }

    public int getUserHighScore(String username) {
        if (username == null) throw new IllegalArgumentException("Username cannot be null");
        int highScore = 0;
        String sql = "SELECT normal_quiz_high_score FROM game_user WHERE username = ?;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql, username);
            if (rowSet.next()) {
                highScore = rowSet.getInt("normal_quiz_high_score");
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return highScore;
    }
    public List<User> getTopTenHighScores() {
        List<User> highScores = new ArrayList<>();
        String sql = "SELECT username, normal_quiz_high_score from game_user\n" +
                "ORDER BY normal_quiz_high_score DESC\n" +
                "LIMIT 10;";
        try {
            SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
            while (rowSet.next()) {
                User user = new User();
                user.setUsername(rowSet.getString("username"));
                user.setNormalHighScore(rowSet.getInt("normal_quiz_high_score"));
                highScores.add(user);
            }
        } catch (CannotGetJdbcConnectionException e) {
            throw new DaoException("Unable to connect to server or database", e);
        }
        return highScores;
    }

    public int setUserHighScore(int score, String username) {
        int updatedHighScore = 0;

        int currentHigh = getUserHighScore(username);
        if (score > currentHigh) {
            String sql = "UPDATE game_user SET normal_quiz_high_score = ? WHERE username = ?;";
            try {
                int rowsAffected = jdbcTemplate.update(sql, score, username);
                if (rowsAffected > 0) {
                    updatedHighScore = score;
                } else {
                    throw new RuntimeException("Failed to update high score for user: " + username);
                }
            } catch (Exception e) {
                throw new RuntimeException("Error updating high score for user: " + username, e);
            }
        }
        return updatedHighScore;
    }
    private Question mapRowToQuestion(SqlRowSet results) {
        Question question = new Question();
        question.setQuestionId(results.getInt("question_id"));
        question.setQuestionPosed(results.getString("question_posed"));
        question.setChoiceA(results.getString("option_a"));
        question.setChoiceB(results.getString("option_b"));
        question.setChoiceC(results.getString("option_c"));
        question.setChoiceD(results.getString("option_d"));
        question.setCorrectAnswer(results.getString("correct_answer"));

        return question;
    }
}


