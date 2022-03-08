package com.techelevator.reservations.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Hotel {

    private int id;
    private String name;
    private Address address;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int stars;

    private int roomsAvailable;
    private double costPerNight;
    private String coverImage;

    public Hotel() {}

    public Hotel(int id, String name, Address address, int stars, int roomsAvailable, double costPerNight) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.stars = stars;
        this.roomsAvailable = roomsAvailable;
        this.costPerNight = costPerNight;
        this.coverImage = "default-cover-image.png";
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" +
                "\n Hotel Details" +
                "\n--------------------------------------------" +
                "\n Id: " + id +
                "\n Name:'" + name + '\'' +
                "\n Stars: " + stars +
                "\n RoomsAvailable: " + roomsAvailable +
                "\n Cost Per Night: " + costPerNight +
                "\n Image:" + coverImage;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public int getRoomsAvailable() {
        return roomsAvailable;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public double getCostPerNight() {
        return costPerNight;
    }

    public void setCostPerNight(double costPerNight) {
        this.costPerNight = costPerNight;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomsAvailable(int roomsAvailable) {
        this.roomsAvailable = roomsAvailable;
    }

    public void setName(String name) {
        this.name = name;
    }
}
