package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.QuizDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Question;
import com.techelevator.tenmo.model.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class QuizController {
    private QuizDao quizDao;
    private UserDao userDao;


    public QuizController(QuizDao quizDao, UserDao userDao) {
        this.quizDao = quizDao;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/quiz/normal/{questionId}", method = RequestMethod.GET)
    public Question getNormalQuizQuestion(@PathVariable int questionId) {
        return quizDao.getNormalQuizQuestion(questionId);
    }
    @RequestMapping (path = "/quiz/normal", method = RequestMethod.GET)
    public List<Question> getNormalQuiz() {
        return quizDao.getNormalQuiz();
    }
    @RequestMapping (path = "/quiz/hard", method = RequestMethod.GET)
    public List<Question> getHardQuiz() {
        return quizDao.getHardQuiz();
    }



    @RequestMapping (path = "/quiz/scores", method = RequestMethod.GET)
    public int getHighScore(Principal principal){
        User user = userDao.getUserByUsername(principal.getName());
        return quizDao.getUserHighScore(user.getUsername());
    }
    @RequestMapping (path = "/quiz/{username}/{score}", method = RequestMethod.PUT)
    public int setHighScore (@PathVariable String username, @PathVariable (required =false) Integer score){
        return quizDao.setUserHighScore(score, username);
    }
    @RequestMapping (path = "/quiz/highScores", method = RequestMethod.GET)
    public List<User> getTopTenHighScores(){
        return quizDao.getTopTenHighScores();
    }
}
