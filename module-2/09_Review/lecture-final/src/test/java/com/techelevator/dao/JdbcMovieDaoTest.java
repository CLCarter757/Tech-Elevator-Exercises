package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class JdbcMovieDaoTest extends BaseDaoTests {
    private static final Movie STEP_BROTHERS = new Movie(1, "Step Brothers", "Two brothers go in search for friendship");


    @Test
    public void getMovie_returns_movie_details_given_valid_id() {
        // Arrange
        JdbcMovieDao sut = new JdbcMovieDao(dataSource);

        // Act
        Movie movie = sut.getMovie(1);

        // Assert
        assertMovieEquals(STEP_BROTHERS, movie);

    }

    @Test
    public void getMovie_returns_null_given_invalid_movie_id() {

    }

    @Test
    public void getAllByDirector_returns_movies_for_James_Cameron() {
        // Arrange
        Movie TITANIC = new Movie(3, "Titanic", "");
        Movie AVATAR = new Movie(2, "Avatar", "");
        JdbcMovieDao sut = new JdbcMovieDao(dataSource);

        // Act
        List<Movie> movies = sut.getAllByDirector(1);

        // Assert
        Assert.assertNotNull(movies);
        Assert.assertEquals(2, movies.size());
        assertMovieEquals(AVATAR, movies.get(0));
        assertMovieEquals(TITANIC, movies.get(1));
    }

    private void assertMovieEquals(Movie expected, Movie actual) {
        Assert.assertEquals(expected.getMovieId(), actual.getMovieId());
        Assert.assertEquals(expected.getTitle(), actual.getTitle());
    }
}
