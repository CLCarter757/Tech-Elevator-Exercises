package com.techelevator;

public class Airplane {
    private String planeNumber;
    private int totalFirstClassSeats;
    private int bookedFirstClassSeats;
    private int totalCoachSeats;
    private int bookedCoachSeats;

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


    public Airplane(String planeNumber, int totalFirstClassSeats, int totalCoachSeats) {
        this.planeNumber = planeNumber;
        this.totalFirstClassSeats = totalFirstClassSeats;
        this.totalCoachSeats = totalCoachSeats;
    }

    public int getAvailableFirstClassSeats() {
        return totalFirstClassSeats - bookedFirstClassSeats;
    }
    public int getAvailableCoachSeats() {
        return totalCoachSeats - bookedCoachSeats;
    }

    public boolean reserveSeats(boolean forFirstClass, int totalNumberOfSeats) {
        if (forFirstClass) {
            if (totalFirstClassSeats - bookedFirstClassSeats >= totalNumberOfSeats) {
                bookedFirstClassSeats += totalNumberOfSeats;
                return true;
            }
            return false;
        }
        if (!forFirstClass) {
            if (totalCoachSeats - bookedCoachSeats >= totalNumberOfSeats) {
                bookedCoachSeats += totalNumberOfSeats;
                return true;
            }
            return false;
        }
        return false;
    }

}
