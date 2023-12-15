package com.techelevator.dao;

import com.techelevator.model.Question;

public interface QuestionDao {

    /**
     * getRandomQuestion returns an unasked questions from the database and returns a question object.
     * @return Question
    */
    Question getRandomQuestion();
}
