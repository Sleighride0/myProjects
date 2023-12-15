package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Question;

public interface QuestionDao {

    /**
     * getRandomQuestion returns an unasked question from the database returns a question object
     * @return Question
     * */
    Question getRandomQuestion();
}
