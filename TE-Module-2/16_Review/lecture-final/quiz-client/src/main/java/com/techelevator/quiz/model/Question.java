package com.techelevator.quiz.model;

public class Question {

    private String question;
    private int questionId;
    private boolean asked;

    public Question(String question, int questionId, boolean asked) {
        this.question = question;
        this.questionId = questionId;
        this.asked = asked;
    }

    public Question() {
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public boolean isAsked() {
        return asked;
    }

    public void setAsked(boolean asked) {
        this.asked = asked;
    }
}
