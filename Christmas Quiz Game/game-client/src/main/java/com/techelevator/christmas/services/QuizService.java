package com.techelevator.christmas.services;

import com.techelevator.christmas.model.Question;
import com.techelevator.util.BasicLogger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;

public class QuizService {

    private final String BASE_URL;
    private final RestTemplate restTemplate = new RestTemplate();
    private String authToken = null;

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public QuizService(String baseUrl) {
        BASE_URL = baseUrl;
    }

    public Question getNormalQuestion(int questionId) {
        Question question = new Question();
        try {
            question = restTemplate.exchange(BASE_URL + "/quiz/normal/" + questionId, HttpMethod.GET,
                    makeAuthEntity(), Question.class).getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return question;
    }
    public int getHighScore(String username) {
        int highScore = 0;
        try {
            highScore = restTemplate.exchange(BASE_URL + "/quiz/scores?username=" + username, HttpMethod.GET,
                    makeAuthEntity(), int.class).getBody();
        } catch (RestClientResponseException | ResourceAccessException e) {
            BasicLogger.log(e.getMessage());
        }
        return highScore;
    }
    public void updateHighScore (String username, int score){
            try{
                restTemplate.exchange(BASE_URL + "/quiz/" + username +"/" + score, HttpMethod.PUT,
                       makeAuthEntity(), Integer.class);
            } catch (RestClientResponseException | ResourceAccessException e){
                BasicLogger.log(e.getMessage());
            }
        }


    private HttpEntity<Integer> createIntegerEntity(int integer){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(integer, headers);
    }

    private HttpEntity<Void> makeAuthEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(authToken);
        return new HttpEntity<>(headers);

    }

}
