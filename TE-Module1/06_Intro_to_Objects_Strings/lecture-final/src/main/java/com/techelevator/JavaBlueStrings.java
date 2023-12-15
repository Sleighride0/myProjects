package com.techelevator;

public class JavaBlueStrings {
    private String givenString;

    public void setGivenString(String strProvided){
        givenString = strProvided;
    }

    public String getGivenString(){
        return givenString;
    }

    public int numberOfCharInGivenStringPlus2(){
        return  givenString.length() + 2;
    }

    public String addJavaBlueCatchPhraseToGivenString(){
        return givenString + " down with ship!";
    }
}
