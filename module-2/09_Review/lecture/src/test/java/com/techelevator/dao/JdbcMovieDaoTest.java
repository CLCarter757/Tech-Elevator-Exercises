package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcMovieDaoTest extends BaseDaoTests {
    private static final Movie STEP_BROTHERS = new Movie(1, "Step Brothers", "Two brothers go in search for friendship", "Two brothers", "some path", "step-brothers.com", "2008-01-10", 90, 10L, 10L);

    private JdbcMovieDao sut;

    @Before
    public void setup() {
        sut = new JdbcMovieDao(dataSource);

    }

    @Test
    public void getMovie_returns_movie_details_given_valid_id() {
        Movie movie = sut.getMovie(1);

        assertMovieEquals(STEP_BROTHERS, movie);
    }

    @Test
    public void getAllByDirector_returns_movies_for_James_Cameron(){
        List<Movie> movies = sut.getAllByDirector(1);

        Assert.assertNotNull(movies);
        Assert.assertEquals(2, movies.size());
        assertMovieEquals(AVATAR, movies.get(0));
        assertMovieEquals(TITANIC, movies.get(1));
    }

    private void assertMovieEquals(Movie expected, Movie actual) {
        Assert.assertEquals(expected.getMovieId(), actual.getMovieId());
        Assert.assertEquals(expected.getTitle(), actual.getTitle());
        Assert.assertEquals(expected.getOverview(), actual.getOverview());
        Assert.assertEquals(expected.getTagline(), actual.getTagline());
        Assert.assertEquals(expected.getPosterPath(), actual.getPosterPath());
        Assert.assertEquals(expected.getHomePage(), actual.getHomePage());
        Assert.assertEquals(expected.getReleaseDate(), actual.getReleaseDate());
        Assert.assertEquals(expected.getLengthInMinutes(), actual.getLengthInMinutes());

    }

}
