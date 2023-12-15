package com.techelevator.quiz.model;

import java.util.List;

public class Quiz {
    private int quizId;
    private int userId;
    private String title;
    private List<Question> questions;

    public Quiz(int quizId, int userId, String title, List<Question> questions) {
        this.quizId = quizId;
        this.userId = userId;
        this.title = title;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
