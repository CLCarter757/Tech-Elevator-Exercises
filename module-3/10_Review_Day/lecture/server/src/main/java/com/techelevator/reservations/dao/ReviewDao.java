package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Review;

import java.util.List;

public interface ReviewDao {
    List<Review> getAll();

    Review add(Review review);
}
