package com.techelevator.hotels;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    public static final int MENU_LIST_HOTELS = 1;
    public static final int MENU_LIST_REVIEWS = 2;
    public static final int MENU_SHOW_DETAILS_HOTEL_ONE = 3;
    public static final int MENU_LIST_REVIEWS_FOR_HOTEL_ONE = 4;
    public static final int MENU_LIST_HOTELS_WITH_3_STARS = 5;
    public static final int MENU_CALL_PUBLIC_API = 6;
    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == MENU_LIST_HOTELS) {
                Hotel[] hotels = hotelService.listHotels();
                consoleService.printHotels(hotels);
            } else if (menuSelection == MENU_LIST_REVIEWS) {
                Review[] reviews = hotelService.listReviews();
                consoleService.printReviews(reviews);
            } else if (menuSelection == MENU_SHOW_DETAILS_HOTEL_ONE) {
                consoleService.printHotel( hotelService.getHotelById(1) );
            } else if (menuSelection == MENU_LIST_REVIEWS_FOR_HOTEL_ONE) {
                consoleService.printReviews( hotelService.getReviewsByHotelId(1) );
            } else if (menuSelection == MENU_LIST_HOTELS_WITH_3_STARS) {
                consoleService.printHotels( hotelService.getHotelsByStarRating(3) );
            } else if (menuSelection == MENU_CALL_PUBLIC_API) {
                hotelService.getWithCustomQuery();
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
