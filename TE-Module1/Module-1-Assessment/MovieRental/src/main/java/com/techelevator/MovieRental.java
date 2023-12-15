package com.techelevator;

public class MovieRental {
    private String title;
    private String format;
    private boolean isPremiumMovie;
    private double rentalPrice;
    private double VHS_PRICE = 0.99;
    private double DVD_PRICE = 1.99;
    private double BLU_RAY_PRICE = 2.99;

    public MovieRental (String title, String format, boolean isPremiumMovie){
        this.title = title;
        this.format = format;
        this.isPremiumMovie = isPremiumMovie;
    }

    public double lateFee(int daysLate) {
        if (daysLate == 0) {
            return 0.00;
        }
        if (daysLate == 1) {
            return 1.99;
        }
        if (daysLate == 2) {
            return 3.99;
        }
            return 19.99;

    }

    public String getTitle() {
        return title;
    }

    public String getFormat() {
        return format;
    }

    public boolean isPremiumMovie() {
        return isPremiumMovie;
    }

    public double getRentalPrice() {
        if (format.equalsIgnoreCase("VHS")){
            rentalPrice = VHS_PRICE;
        }
        if (format.equalsIgnoreCase("DVD")){
            rentalPrice = DVD_PRICE;
        }
        if (format.equalsIgnoreCase("Blu-Ray")){
            rentalPrice = BLU_RAY_PRICE;
        }
        if (isPremiumMovie){
            rentalPrice += 1.00;
        }
        return rentalPrice;
    }


    @Override
    public String toString() {
        return "MOVIE - " + title + " - " + format + " " + rentalPrice;
    }
}
