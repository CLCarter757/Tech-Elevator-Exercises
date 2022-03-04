package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.ReviewDao;
import com.techelevator.reservations.exception.ReviewNotFoundException;
import com.techelevator.reservations.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class ReviewController {

    @Autowired
    private ReviewDao reviewDao;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping("/reviews")
    public Review createReview(@RequestBody @Valid Review review) throws ReviewNotFoundException {
        return reviewDao.create(review);
    }
}
