package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats){
    this.planeNumber = planeNumber;
    this.totalFirstClassSeats = totalFirstClassSeats;
    this.totalCoachSeats = totalCoachSeats;
    }

    //getters
    public String getPlaneNumber() {
        return planeNumber;
    }

    public int getTotalFirstClassSeats() {
        return totalFirstClassSeats;
    }

    public int getBookedFirstClassSeats() {
        return bookedFirstClassSeats;
    }

    public int getTotalCoachSeats() {
        return totalCoachSeats;
    }

    public int getBookedCoachSeats() {
        return bookedCoachSeats;
    }
    public int getAvailableFirstClassSeats(){
       return this.totalFirstClassSeats - this.bookedFirstClassSeats;
    }
    public int getAvailableCoachSeats(){
        return this.totalCoachSeats - this.bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats){
        if (forFirstClass == true) {
            if (getAvailableFirstClassSeats() > totalNumberOfSeats) {
                bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            }
        }
        if (forFirstClass == false) {
            if (getAvailableCoachSeats() > totalNumberOfSeats) {
                bookedCoachSeats += totalNumberOfSeats;
                return true;
            }
        }
        return false;
    }
}
