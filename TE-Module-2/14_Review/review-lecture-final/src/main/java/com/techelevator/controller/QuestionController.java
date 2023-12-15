package com.techelevator.controller;

import com.techelevator.dao.QuestionDao;
import com.techelevator.model.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuestionController {

    private QuestionDao questionDao;

    public QuestionController(QuestionDao questionDao){
        this.questionDao = questionDao;
    }

    @RequestMapping(path = "/questions/random", method = RequestMethod.GET)
    public Question getRandomQuestion(){
        return questionDao.getRandomQuestion();
    }


}
