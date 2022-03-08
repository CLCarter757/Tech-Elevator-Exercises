package com.techelevator.reservations.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import org.apache.tomcat.jni.Local;

import javax.validation.constraints.*;
import java.security.Principal;
import java.time.LocalDate;

public class Reservation {

    private int id;

    @JsonProperty("hotelID")
    @Min(value = 1, message = "hotelID should be a positive integer value")
    private int hotelId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String username;

    @NotBlank(message = "fullName is required and cannot be blank")
    private String fullName;

    @JsonFormat(pattern = "yyyy-MM-dd") // Formats the data going back to the client
    @JsonDeserialize(using = LocalDateDeserializer.class) // Handles deserializing a String e.g. "2022-03-05" into a LocalDate
    @FutureOrPresent
    private LocalDate checkinDate;

    @JsonFormat(pattern = "yyyy-MM-dd") // Formats the data going back to the client
    @JsonDeserialize(using = LocalDateDeserializer.class) // Handles deserializing a String e.g. "2022-03-05" into a LocalDate
    @Future
    private LocalDate checkoutDate;

    @Positive(message = "The number of guests should be a positive integer value")
    @Max(value = 5, message = "The maximum number of guests allowed is 5")
    private int guests;

    @AssertTrue(message = "checkinDate must be less than checkoutDate")
    private boolean isCheckinDateIsPriorToCheckoutDate() {
        /*
            compareTo returns negative, 0, positive
            negative indicates <
            0 indicates ==
            positive indicates >
         */

        return checkinDate.compareTo(checkoutDate) < 0;
    }

    public Reservation() {}

    public Reservation(int id, int hotelId, String fullName, LocalDate checkinDate, LocalDate checkoutDate, int guests) {
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

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }

    public LocalDate getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(LocalDate checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "\n--------------------------------------------" + "\n Reservation Details"
                + "\n--------------------------------------------" + "\n Id: " + id + "\n Hotel Id: " + hotelId
                + "\n Full Name: " + fullName + "\n Checkin Date: " + checkinDate + "\n Checkout Date: " + checkoutDate
                + "\n Guests: " + guests;
    }

    public boolean canUserUpdateOrDelete(Principal principal) {
        return isReservationUpcoming() && this.username.equals(principal.getName());
    }

    private boolean isReservationUpcoming() {
        return this.checkinDate.compareTo(LocalDate.now()) > 0;
    }
}
