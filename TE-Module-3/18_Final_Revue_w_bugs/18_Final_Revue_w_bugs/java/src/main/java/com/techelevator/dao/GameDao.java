package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface GameDao {

    List<GameTitle> getGameTitles();

    int addGamePlayRecord(GamePlayDto gamePlayDto, User currentUser);

    List<GameDto> getPlayedGames(int currentUserId);

    int addMatchForGamePlayRecord(MatchGame matchGame);
}
