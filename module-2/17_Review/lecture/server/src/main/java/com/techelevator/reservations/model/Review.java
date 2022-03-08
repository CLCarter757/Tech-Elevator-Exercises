package com.techelevator.reservations.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class Review {
    private int id;
    private int hotelId;
    private String author;

    @NotNull
    private String title;
    private String description;

    @NotNull
    @Min(value = 1)
    @Max(value = 5)
    private int stars;

    // workaround for min and max on doubles
//    private double balance;
//
//    @AssertTrue
//    private boolean isBalanceBetweenOneAndOnePointFive() {
//        return balance >= 1.0 && balance <= 1.5;
//    }

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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
