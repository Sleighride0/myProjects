package com.techelevator.quiz.services;

import com.techelevator.quiz.model.Question;
import com.techelevator.quiz.model.Quiz;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class QuizService {
    private final String baseUrl;
    private final RestTemplate restTemplate = new RestTemplate();

    private String authToken = null;

    public QuizService(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public void setAuthToken(String authToken){
        this.authToken = authToken;
    }
    public Question getRandomQuestion(){
        Question question = null;
        try{
          question = restTemplate.getForObject(baseUrl + "/questions/random", Question.class);
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return question;
    }

    public List<Quiz> getUserQuizzes(){
        HttpHeaders header = new HttpHeaders();
        header.setBearerAuth(authToken);
        HttpEntity entity = new HttpEntity<>(header);
        List<Quiz> quizzes = null;
        try{
            quizzes = Arrays.asList(restTemplate.exchange(baseUrl + "/users/quizzes", HttpMethod.GET, entity,Quiz[].class).getBody());
        }catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return quizzes;
    }


}
