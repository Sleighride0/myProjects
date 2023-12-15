package com.techelevator.dao;

import com.techelevator.model.Question;

public interface QuestionDao {

    /**
     * getRandomQuestion returns an unasked question from the database returns a question object
     * @return Question
     * */
    Question getRandomQuestion();
}
