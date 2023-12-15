package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Question;
import com.techelevator.tenmo.model.QuizDto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcQuizDao implements QuizDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcQuizDao(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public List<QuizDto> getUserQuizzes(int userId) {
        List<QuizDto> quizDtos = new ArrayList<>();
        String sql = "SELECT quiz_id, title, user_id, is_public  FROM quiz \n" +
                "WHERE user_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, userId);
        while(results.next()){
            QuizDto quiz = new QuizDto();
            quiz.setQuizId(results.getInt("quiz_id"));
            quiz.setTitle(results.getString("title"));
            quiz.setUserId(userId);
            quiz.setPublic(results.getBoolean("is_public"));
            quiz.setQuestions(getQuizQuestions(quiz.getQuizId()));
            quizDtos.add(quiz);
        }
        return quizDtos;
    }

    public List<Question> getQuizQuestions(int quizId){
        List<Question> questions = new ArrayList<>();
        //don't forget to do the good stuff like exception handling
        String sql = "SELECT question_id,question_text,asked FROM question\n" +
                "WHERE question_id IN (SELECT question_id FROM quiz_question WHERE quiz_id = ?)";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, quizId);
        while(results.next()){
            Question question = mapRowToQuestion(results);
            questions.add(question);
        }
        return questions;
    }

    private Question mapRowToQuestion(SqlRowSet results) {
        Question question = new Question();
        question.setQuestionId(results.getInt("question_id"));
        question.setQuestion(results.getString("question_text"));
        question.setAsked(results.getBoolean("asked"));
        return question;
    }
}
