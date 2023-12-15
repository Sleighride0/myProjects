package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.model.Country;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {
        String url = API_BASE_URL + "/hotels";
        Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class);
        return hotels;
    }

    public Review[] listReviews() {
        String url = API_BASE_URL + "/reviews";
        return restTemplate.getForObject(url, Review[].class);
    }

    public Hotel getHotelById(int id) {
        String url = API_BASE_URL + "/hotels/" + id;
        Hotel hotel = restTemplate.getForObject(url, Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelId) {
        String url = API_BASE_URL + "/hotels/" + hotelId + "/reviews";
        return restTemplate.getForObject(url, Review[].class);
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        String url = API_BASE_URL + "/hotels?stars=" + stars;
        return restTemplate.getForObject(url, Hotel[].class);
    }

    public City getWithCustomQuery(){
        Country country = restTemplate.getForObject("https://api.country.is/", Country.class);
        return null;
    }

}
