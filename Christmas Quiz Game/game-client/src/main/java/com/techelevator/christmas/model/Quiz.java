package com.techelevator.christmas.model;

import java.util.List;

public class Quiz {


    private int quizId;
    private String title;
    private int userId;

    private List<Question> questions;

    public Quiz(int quizId, String title, int userId, List<Question> questions) {
        this.quizId = quizId;
        this.title = title;
        this.userId = userId;
        this.questions = questions;
    }

    public Quiz() {
    }

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }



    public List<Question> getQuestions() {
        return questions;
    }


}

