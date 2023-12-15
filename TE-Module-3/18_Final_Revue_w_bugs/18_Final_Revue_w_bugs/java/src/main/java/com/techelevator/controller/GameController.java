package com.techelevator.controller;

import com.techelevator.dao.GameDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.*;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@CrossOrigin
@RestController
public class GameController {
    private GameDao gameDao;
    private UserDao userDao;

    public GameController(GameDao gameDao, UserDao userDao){
        this.gameDao = gameDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/games", method = RequestMethod.GET)
    public List<GameTitle> getGameTitles(){
        return gameDao.getGameTitles();
    }

    @RequestMapping(path = "/games", method = RequestMethod.POST)
    public int addGamePlay(@RequestBody GamePlayDto gamePlayDto, Principal principal){
        User currentUser = userDao.getUserByUsername(principal.getName());
        return gameDao.addGamePlayRecord(gamePlayDto, currentUser);
    }

    @RequestMapping(path = "/games/stats", method = RequestMethod.GET)
    public List<GameDto> getUserGameStats(Principal principal){
        User currentUser = userDao.getUserByUsername(principal.getName());
        return gameDao.getPlayedGames(currentUser.getId());
    }

    @RequestMapping(path = "/games/{id}", method = RequestMethod.POST)
    public void addMatchByGamePlayId(@RequestBody MatchGame matchGame){
        gameDao.addMatchForGamePlayRecord(matchGame);
    }
}
