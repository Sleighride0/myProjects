package com.techelevator.controller;

import com.techelevator.dao.GameDao;
import com.techelevator.model.GameTitle;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class GameController {
    private GameDao gameDao;

    public GameController(GameDao gameDao){
        this.gameDao = gameDao;
    }

    @RequestMapping(path = "/games", method = RequestMethod.GET)
    public List<GameTitle> getGameTitles(){
        return gameDao.getGameTitles();
    }
}
