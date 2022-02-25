package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Movie create(Movie movie) {
        String sql = "INSERT INTO movie " +
                "(title, overview, tagline, poster_path, home_page, release_date, length_minutes, director_id, collection_id) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?) " +
                "RETURNING movie_id;";

        Long newMovieId = jdbcTemplate.queryForObject(sql, Long.class,
                movie.getTitle(),
                movie.getOverview(),
                movie.getTagline(),
                movie.getPosterPath(),
                movie.getHomePage(),
                movie.getReleaseDate(),
                movie.getLengthInMinutes(),
                movie.getDirectorId(),
                movie.getCollectionId());

        Movie newMovie = getMovie(newMovieId);

        return newMovie;
    }

    @Override
    public Movie getMovie(long movieId) {
        Movie movie = null;

        String sql = "SELECT movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, " +
                "director_id, collection_id " +
                "FROM movie " +
                "WHERE movie_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, movieId);

        if(results.next()) {
            movie = mapResultToMovie(results);
        }

        return movie;
    }


    @Override
    public List<Movie> getAll() {
        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT movie_id, title, overview, tagline, poster_path, home_page, release_date, length_minutes, " +
                "director_id, collection_id " +
                "FROM movie;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Movie movie = mapResultToMovie(results);

            movies.add(movie);
        }

        return movies;
    }

    @Override
    public void update(Movie movie) {
        String sql =
                "UPDATE movie " +
                "SET title = ?, " +
                    "overview = ?, " +
                    "tagline = ?, " +
                    "poster_path = ?, " +
                    "home_page = ?, " +
                    "release_date = ?, " +
                    "length_minutes = ?, " +
                    "director_id = ?, " +
                    "collection_id = ? " +
                "WHERE movie_id = ?;";

        jdbcTemplate.update(sql,
                movie.getTitle(),
                movie.getOverview(),
                movie.getTagline(),
                movie.getPosterPath(),
                movie.getHomePage(),
                movie.getReleaseDate(),
                movie.getLengthInMinutes(),
                movie.getDirectorId(),
                movie.getCollectionId(),
                movie.getMovieId());
    }

    @Override
    public void delete(long movieId) {
        String sql = "DELETE FROM movie_actor WHERE movie_id = ?;" +
                "DELETE FROM movie_genre WHERE movie_id = ?; " +
                "DELETE FROM movie WHERE movie_id = ?;";

        jdbcTemplate.update(sql, movieId, movieId, movieId);
    }

    @Override
    public List<Movie> searchByTimeRange(int minimumLength, int maximumLength) {
        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM movie WHERE length_minutes BETWEEN ? AND ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, minimumLength, maximumLength);

        while(results.next()) {
            Movie movie = mapResultToMovie(results);

            movies.add(movie);
        }

        return movies;
    }

    @Override
    public List<Movie> getAllByDirector(long directorId) {
        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM movie WHERE director_id = ? ORDER BY movie_id;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, directorId);

        while(results.next()) {
            Movie movie = mapResultToMovie(results);

            movies.add(movie);
        }

        return movies;
    }

    private Movie mapResultToMovie(SqlRowSet results) {
        Movie movie = new Movie();

        movie.setMovieId(results.getLong("movie_id"));

        movie.setTitle(results.getString("title"));

        movie.setTagline(results.getString("tagline"));

        movie.setOverview(results.getString("overview"));

        movie.setPosterPath(results.getString("poster_path"));

        movie.setHomePage(results.getString("home_page"));

        Date releaseDate = results.getDate("release_date");

        if(releaseDate != null) {
            movie.setReleaseDate(releaseDate.toLocalDate());
        }

        movie.setLengthInMinutes(results.getInt("length_minutes"));

        long directorId = results.getLong("director_id");

        if(!results.wasNull()) {
            movie.setDirectorId(directorId);
        }

        long collectionId = results.getLong("collection_id");

        if(!results.wasNull()) {
            movie.setCollectionId(collectionId);
        }


        return movie;
    }
}
