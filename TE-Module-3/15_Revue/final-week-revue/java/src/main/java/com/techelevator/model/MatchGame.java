package com.techelevator.model;

import java.time.LocalDate;

public class MatchGame {
    private int matchId;
    private int gamePlayId;
    private int matchWinnerId;
    private int matchSecondWinnerId;
    private LocalDate dateTimeOfMatch;

    public MatchGame(int matchId, int gamePlayId, int matchWinnerId, int matchSecondWinnerId, LocalDate dateTimeOfMatch) {
        this.matchId = matchId;
        this.gamePlayId = gamePlayId;
        this.matchWinnerId = matchWinnerId;
        this.matchSecondWinnerId = matchSecondWinnerId;
        this.dateTimeOfMatch = dateTimeOfMatch;
    }

    public MatchGame() {
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getGamePlayId() {
        return gamePlayId;
    }

    public void setGamePlayId(int gamePlayId) {
        this.gamePlayId = gamePlayId;
    }

    public int getMatchWinnerId() {
        return matchWinnerId;
    }

    public void setMatchWinnerId(int matchWinnerId) {
        this.matchWinnerId = matchWinnerId;
    }

    public int getMatchSecondWinnerId() {
        return matchSecondWinnerId;
    }

    public void setMatchSecondWinnerId(int matchSecondWinnerId) {
        this.matchSecondWinnerId = matchSecondWinnerId;
    }

    public LocalDate getDateTimeOfMatch() {
        return dateTimeOfMatch;
    }

    public void setDateTimeOfMatch(LocalDate dateTimeOfMatch) {
        this.dateTimeOfMatch = dateTimeOfMatch;
    }
}
