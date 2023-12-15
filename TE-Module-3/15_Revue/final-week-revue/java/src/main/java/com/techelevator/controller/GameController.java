package com.techelevator.controller;

import com.techelevator.dao.GameDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.GamePlayDto;
import com.techelevator.model.GameTitle;
import com.techelevator.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class GameController {

    public GameDao gameDao;
    private UserDao userDao;

    public GameController(GameDao gameDao, UserDao userDao) {
        this.gameDao = gameDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/games", method = RequestMethod.GET)
    public List<GameTitle> getGameTitles(){
        return gameDao.getGameTitles();
    }
@RequestMapping(path = "/games", method = RequestMethod.POST)
    public void addGamePlay(@RequestBody GamePlayDto gamePlayDto, Principal principal){
        User currentUser = userDao.getUserByUsername(principal.getName());
        gameDao.addGamePlayRecord(gamePlayDto, currentUser);
}
}
