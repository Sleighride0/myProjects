package com.techelevator.reservations.model;

import javax.validation.constraints.*;

public class Reservation {

    private int id;
    @Min(value = 1, message = "Hotel ID must be provided")
    private int hotelId;
    @NotBlank(message = "Please provide the name of our guest")
    private String fullName;
    @NotBlank(message = "You must provide a date for check in")
    //@FutureOrPresent(message = "Must provide a current or future date")
    private String checkinDate;
    @NotBlank(message = "You must provide a date for checkout")
   // @Future(message = "Must provide a future date")
    private String checkoutDate;
    @Min(value = 1, message = "You must have at least 1 guest")
    @Max(value = 5,message = "Max guests is 5")
    private int guests;

    public Reservation(int id, int hotelId, String fullName, String checkinDate, String checkoutDate, int guests) {
        this.id = id;
        this.hotelId = hotelId;
        this.fullName = fullName;
        this.checkinDate = checkinDate;
        this.checkoutDate = checkoutDate;
        this.guests = guests;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelId
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }
}
