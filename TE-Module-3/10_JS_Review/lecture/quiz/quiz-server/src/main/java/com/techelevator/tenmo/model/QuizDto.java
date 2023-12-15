package com.techelevator.tenmo.model;

import java.util.List;

public class QuizDto {
    private int quizId;
    private String title;
    private int userId;
    private boolean isPublic;

    private List<Question> questions;

    public QuizDto(int quizId, String title, int userId, boolean isPublic, List<Question> questions) {
        this.quizId = quizId;
        this.title = title;
        this.userId = userId;
        this.isPublic = isPublic;
        this.questions = questions;
    }

    public QuizDto() {
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

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }
}
