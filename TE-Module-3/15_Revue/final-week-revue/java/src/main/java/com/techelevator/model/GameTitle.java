package com.techelevator.model;

public class GameTitle {
    private int gameTitleId;
    private String gameName;
    private String gameImgURL;

    public GameTitle(int gameTitleId, String gameName, String gameImgURL) {
        this.gameTitleId = gameTitleId;
        this.gameName = gameName;
        this.gameImgURL = gameImgURL;
    }

    public GameTitle() {
    }

    public int getGameTitleId() {
        return gameTitleId;
    }

    public void setGameTitleId(int gameTitleId) {
        this.gameTitleId = gameTitleId;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameImgURL() {
        return gameImgURL;
    }

    public void setGameImgURL(String gameImgURL) {
        this.gameImgURL = gameImgURL.replace("\\","/");
    }
}
