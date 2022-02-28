package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface MovieDao {

    //CRUD
    //create
    public Movie create(Movie movie);

    //retrieve
    Movie getMovie(long movieId);

    List<Movie> getAll();


    //update
    void update(Movie movie);


    //delete
    void delete(long movieId);


    //search by time range
    List<Movie> searchByTimeRange(int minimumLength, int maximumLength);


    //Get all movies by a director
    List<Movie> getAllByDirector(long directorId);
}
