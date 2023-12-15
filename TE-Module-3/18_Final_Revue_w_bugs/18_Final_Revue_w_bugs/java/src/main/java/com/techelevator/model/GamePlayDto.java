package com.techelevator.model;

public class GamePlayDto {
    private int opponentId;
    private int gameTitleId;

    public GamePlayDto(int opponentId, int gameTitleId) {
        this.opponentId = opponentId;
        this.gameTitleId = gameTitleId;
    }

    public GamePlayDto() {
    }

    public int getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(int opponentId) {
        this.opponentId = opponentId;
    }

    public int getGameTitleId() {
        return gameTitleId;
    }

    public void setGameTitleId(int gameTitleId) {
        this.gameTitleId = gameTitleId;
    }
}
