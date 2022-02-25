package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDao {

    // CRUD
    // create
    Movie create(Movie movie);

    // retrieve
    Movie getMovie(long movieId);

    List<Movie> getAll();

    // update
    void update(Movie movie);

    // delete
    void delete(long movieId);

    // search by genre
    // search by time range
    List<Movie> searchByTimeRange(int minimumLength, int maximumLength);

    // get all from collection
    // get all by director
    List<Movie> getAllByDirector(long directorId);

    // get all by actor
    // add to collection -- add a personal collection
    // get all from a date range
    // get all by rating
    // get all by actor and director
}
