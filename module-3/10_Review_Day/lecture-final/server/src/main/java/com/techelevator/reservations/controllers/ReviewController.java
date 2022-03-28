package com.techelevator.reservations.controllers;

import com.techelevator.reservations.dao.ReviewDao;
import com.techelevator.reservations.model.Review;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class ReviewController {

    private final ReviewDao dao;

    public ReviewController(ReviewDao dao) {
        this.dao = dao;
    }

    /**
     * Return All Reviews
     *
     * @return a list of all reviews in the system
     */
    @RequestMapping(path = "/reviews", method = RequestMethod.GET)
    public List<Review> getAll() {
        return dao.getAll();
    }

    /**
     * Add a reviews
     *
     * @return the review that was created
     */
    @ResponseStatus(code = HttpStatus.CREATED)
    @RequestMapping(path = "/reviews", method = RequestMethod.POST)
    public Review add(@RequestBody @Valid Review review) {
        return dao.add(review);
    }

}
