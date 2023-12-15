package com.techelevator.quiz.services;

import com.techelevator.quiz.model.Question;
import com.techelevator.util.BasicLogger;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import org.springframework.http.HttpHeaders;

public class QuizService {

    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    public QuizService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public Question getRandomQuestion() {
        Question question = null;
        try {
           question = restTemplate.getForObject(baseUrl + "/questions/random", Question.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return question;
    }
}
