package com.techelevator.model;

public class GamePlayDto {

    private int opponentId;
    private int gameTitleId;
    //they dont need to give us their name as we could use principal
    // dont need date as we can use a date.now or something like that


    public GamePlayDto(int opponentId, int gameTitleId) {
        this.opponentId = opponentId;
        this.gameTitleId = gameTitleId;
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
