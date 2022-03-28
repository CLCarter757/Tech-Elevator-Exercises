package com.techelevator.reservations.model;

import javax.validation.constraints.NotBlank;

public class Review {
    @NotBlank
    private String username;
    @NotBlank
    private String title;
    @NotBlank
    private String review;

    private String avatar = "assets/img/user-1.png";
    private String publishedOn = "January 20, 2019 | 10:30 AM";

    public Review() {}

    public Review(String username, String avatar, String title, String publishedOn, String review) {
        this.username = username;
        this.avatar = avatar;
        this.title = title;
        this.publishedOn = publishedOn;
        this.review = review;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishedOn() {
        return publishedOn;
    }

    public void setPublishedOn(String publishedOn) {
        this.publishedOn = publishedOn;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
}
