package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.QuestionDao;
import com.techelevator.tenmo.dao.QuizDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Question;
import com.techelevator.tenmo.model.QuizDto;
import com.techelevator.tenmo.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;
@CrossOrigin
@RestController
public class QuizController {

    private QuestionDao questionDao;

    private QuizDao quizDao;

    private UserDao userDao;

    public QuizController(QuestionDao questionDao, QuizDao quizDao, UserDao userDao){
        this.questionDao = questionDao;
        this.quizDao = quizDao;
        this.userDao = userDao;
    }


    @RequestMapping(path = "/questions/random", method = RequestMethod.GET)
    public Question getRandomQuestion(){
        return questionDao.getRandomQuestion();
    }

    @RequestMapping(path = "/users/quizzes", method = RequestMethod.GET)
    public List<QuizDto> getUserQuizzes(Principal principal){
        User user = userDao.getUserByUsername( principal.getName());

        return quizDao.getUserQuizzes(user.getId());
    }
}
