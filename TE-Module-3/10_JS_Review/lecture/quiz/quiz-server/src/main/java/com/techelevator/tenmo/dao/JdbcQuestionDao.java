package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Question;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class JdbcQuestionDao implements QuestionDao{

    private JdbcTemplate jdbcTemplate;
    public JdbcQuestionDao(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Question getRandomQuestion() {
        String sql = "SELECT question_id, question_text, question.asked FROM question WHERE asked = false ORDER BY RANDOM() LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        Question question = null;
        if(results.next()){
            question = mapRowToQuestion(results);
            //call updateQuestionAskedStatus()
        } //else call resetQuestionAsked()
        return question;
    }

    //write a method that updated the question table where question_id is equal to randomly selected question to set asked to true;

    //add logic to check if question is null, then call a method to reset the question table asked to false;

    private Question mapRowToQuestion(SqlRowSet results) {
        Question question = new Question();
        question.setQuestionId(results.getInt("question_id"));
        question.setQuestion(results.getString("question_text"));
        question.setAsked(results.getBoolean("asked"));
        return question;
    }
}

