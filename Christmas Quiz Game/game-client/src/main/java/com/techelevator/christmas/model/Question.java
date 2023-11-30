package com.techelevator.christmas.model;

public class Question {

    private int questionId;

    private String questionPosed;

    private String choiceA;
    private String choiceB;
    private String choiceC;
    private String choiceD;
    private String correctAnswer;



    public Question(int questionId, String questionPosed, String choiceA, String choiceB, String choiceC, String choiceD, String correctAnswer) {
        this.questionId = questionId;
        this.questionPosed = questionPosed;
        this.choiceA = choiceA;
        this.choiceB = choiceB;
        this.choiceC = choiceC;
        this.choiceD = choiceD;
        this.correctAnswer = correctAnswer;
    }
    public Question(){}

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionPosed() {
        return questionPosed;
    }

    public void setQuestionPosed(String questionPosed) {
        this.questionPosed = questionPosed;
    }

    public String getChoiceA() {
        return choiceA;
    }

    public void setChoiceA(String choiceA) {
        this.choiceA = choiceA;
    }

    public String getChoiceB() {
        return choiceB;
    }

    public void setChoiceB(String choiceB) {
        this.choiceB = choiceB;
    }

    public String getChoiceC() {
        return choiceC;
    }

    public void setChoiceC(String choiceC) {
        this.choiceC = choiceC;
    }

    public String getChoiceD() {
        return choiceD;
    }

    public void setChoiceD(String choiceD) {
        this.choiceD = choiceD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }
}
