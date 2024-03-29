package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Question;
import com.techelevator.tenmo.model.User;

import java.util.List;

public interface QuizDao {

    public Question getNormalQuizQuestion (int questionId);
    public List<Question> getNormalQuiz();
    public List<Question> getHardQuiz();
    public int getUserHighScore(String username);
    public int setUserHighScore (int score, String username);

    public List<User> getTopTenHighScores();


}
