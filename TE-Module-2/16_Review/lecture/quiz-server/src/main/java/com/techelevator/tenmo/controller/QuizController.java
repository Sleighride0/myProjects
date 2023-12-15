package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.QuestionDao;
import com.techelevator.tenmo.model.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuizController {

    public QuestionDao questionDao;

    public QuizController(QuestionDao questionDao){
        this.questionDao = questionDao;
    }
    @RequestMapping(path = "/questions/random", method = RequestMethod.GET)
    public Question getRandomQuestion(){
        return questionDao.getRandomQuestion();
    }
}


