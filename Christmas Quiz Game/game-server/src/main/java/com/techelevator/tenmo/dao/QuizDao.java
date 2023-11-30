package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Question;

import java.util.List;

public interface QuizDao {

    public Question getNormalQuizQuestion (int questionId);
    public List<Question> getNormalQuiz();
    public int getUserHighScore(String username);
    public int setUserHighScore (int score, String username);

}
