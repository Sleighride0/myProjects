package com.techelevator.model;

import java.util.List;

public class Game {
    private int currentUserId;
    private int gameTitleId;
    private int opponentId;

    private List<MatchGame> matches;
    private int gameWinnerId;
    private int gameSecondWinnerId;

    public Game(int currentUserId, int gameTitleId, int opponentId, List<MatchGame> matches, int gameWinnerId, int gameSecondWinnerId) {
        this.currentUserId = currentUserId;
        this.gameTitleId = gameTitleId;
        this.opponentId = opponentId;
        this.matches = matches;
        this.gameWinnerId = gameWinnerId;
        this.gameSecondWinnerId = gameSecondWinnerId;
    }

    public Game() {
    }

    public int getCurrentUserId() {
        return currentUserId;
    }

    public void setCurrentUserId(int currentUserId) {
        this.currentUserId = currentUserId;
    }

    public int getGameTitleId() {
        return gameTitleId;
    }

    public void setGameTitleId(int gameTitleId) {
        this.gameTitleId = gameTitleId;
    }

    public int getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(int opponentId) {
        this.opponentId = opponentId;
    }

    public List<MatchGame> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchGame> matches) {
        this.matches = matches;
    }

    public int getGameWinnerId() {
        return gameWinnerId;
    }

    public void setGameWinnerId(int gameWinnerId) {
        this.gameWinnerId = gameWinnerId;
    }

    public int getGameSecondWinnerId() {
        return gameSecondWinnerId;
    }

    public void setGameSecondWinnerId(int gameSecondWinnerId) {
        this.gameSecondWinnerId = gameSecondWinnerId;
    }
}
