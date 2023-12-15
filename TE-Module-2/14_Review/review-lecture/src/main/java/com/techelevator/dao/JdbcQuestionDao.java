package com.techelevator.dao;

import com.techelevator.model.Question;
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
        String sql = "SELECT question_id, question, asked FROM question WHERE asked = false ORDER BY RANDOM() LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        Question question = null;
        if(results.next()){
            question = mapRowToQuestion(results);
        }
        return question;
    }


    private Question mapRowToQuestion(SqlRowSet results) {
        Question question = new Question();
        question.setQuestionId(results.getInt("question_id"));
        question.setQuestion(results.getString("question"));
        question.setAsked(results.getBoolean("asked"));
        return question;
    }
}
