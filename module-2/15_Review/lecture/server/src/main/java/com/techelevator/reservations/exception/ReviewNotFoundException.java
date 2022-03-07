package com.techelevator.reservations.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Review not found.")
public class ReviewNotFoundException extends Exception {
    public ReviewNotFoundException() {
        super("Review not found.");
    }
}
