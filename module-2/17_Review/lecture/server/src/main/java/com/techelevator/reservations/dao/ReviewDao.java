package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.ReviewNotFoundException;
import com.techelevator.reservations.model.Review;

public interface ReviewDao {

    Review create(Review review) throws ReviewNotFoundException;
}
