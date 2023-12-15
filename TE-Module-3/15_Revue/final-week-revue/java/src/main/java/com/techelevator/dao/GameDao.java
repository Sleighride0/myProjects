package com.techelevator.dao;

import com.techelevator.model.GamePlayDto;
import com.techelevator.model.GameTitle;
import com.techelevator.model.User;

import java.util.List;

public interface GameDao {
    public List<GameTitle> getGameTitles();

    public void addGamePlayRecord(GamePlayDto gamePlayDto, User currentUser);
}
