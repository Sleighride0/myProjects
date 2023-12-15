package com.techelevator;

public class HomeworkAssignment {


private int earnedMarks;
private  int possibleMarks;
private String submitterName;

public HomeworkAssignment (int possibleMarks, String submitterName){
    this.submitterName = submitterName;
    this.possibleMarks = possibleMarks;
}

public int getPossibleMarks(){
    return possibleMarks;
}

    public int getEarnedMarks() {
        return earnedMarks;
    }

    public String getSubmitterName() {
        return submitterName;
    }

    public void setEarnedMarks(int earnedMarks) {
        this.earnedMarks = earnedMarks;
    }

    public String getLetterGrade(){
        if ( ((double)earnedMarks / possibleMarks) * 100 > 89){
            return "A";
        }
        if ( ((double)earnedMarks / possibleMarks) *100 > 79){
            return "B";
        }
        if ( ((double)earnedMarks / possibleMarks) *100 > 69){
            return "C";
        }
        if ( ((double)earnedMarks / possibleMarks) *100 > 59){
            return "D";
        } return "F";
    }

}
