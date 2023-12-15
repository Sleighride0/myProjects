package com.techelevator.dao;

import com.techelevator.model.GameTitle;

import java.util.List;

public interface GameDao {

    public List<GameTitle> getGameTitles();
}
