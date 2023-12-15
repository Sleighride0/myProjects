package com.techelevator.model;

import java.util.List;

public class GameDto {

    private int gamePlayId;
    private int gameTitleId;

    private String gameName;
    private String opponentUsername;
    private List<MatchGame> matches;
    private boolean isGameWinner;
    private boolean isTie;

    public GameDto(int gamePlayId, int gameTitleId, List<MatchGame> matches, boolean isGameWinner, boolean isTie, String gameName) {
        this.gameTitleId = gameTitleId;
        this.matches = matches;
        this.isGameWinner = isGameWinner;
        this.isTie = isTie;
        this.gamePlayId = gamePlayId;
        this.gameName = gameName;
    }

    public GameDto() {
    }

    public boolean isGameWinner() {
        return isGameWinner;
    }

    public void setGameWinner(boolean gameWinner) {
        isGameWinner = gameWinner;
    }

    public boolean isTie() {
        return isTie;
    }

    public void setTie(boolean tie) {
        isTie = tie;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getOpponentUsername() {
        return opponentUsername;
    }

    public void setOpponentUsername(String opponentUsername) {
        this.opponentUsername = opponentUsername;
    }

    public int getGamePlayId() {
        return gamePlayId;
    }

    public void setGamePlayId(int gamePlayId) {
        this.gamePlayId = gamePlayId;
    }

    public int getGameTitleId() {
        return gameTitleId;
    }

    public void setGameTitleId(int gameTitleId) {
        this.gameTitleId = gameTitleId;
    }

    public List<MatchGame> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchGame> matches) {
        this.matches = matches;
    }

}

