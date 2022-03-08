package com.techelevator.reservations.dao;

import com.techelevator.reservations.exception.ReviewNotFoundException;
import com.techelevator.reservations.model.Review;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JdbcReviewDao implements ReviewDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcReviewDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Review create(Review review) throws ReviewNotFoundException {
        String sql = "INSERT INTO review (hotel_id, author, title, description, stars) " +
                "VALUES (?, ?, ?, ?, ?) RETURNING review_id;";

        Integer reviewId = jdbcTemplate.queryForObject(sql, Integer.class,
                review.getHotelId(),
                review.getAuthor(),
                review.getTitle(),
                review.getDescription(),
                review.getStars());

        return get(reviewId);
    }

    private Review get(int reviewId) throws ReviewNotFoundException {

        String sql = "SELECT review_id, hotel_id, author, title, description, stars " +
                "FROM review " +
                "WHERE review_id = ?;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, reviewId);

        if(results.next()) {
            return mapRowToReview(results);
        }

        throw new ReviewNotFoundException();
    }

    private Review mapRowToReview(SqlRowSet row) {
        Review review = new Review();


        review.setId(row.getInt("review_id"));

        review.setHotelId(row.getInt("hotel_id"));

        review.setAuthor(row.getString("author"));

        review.setTitle(row.getString("title"));

        review.setDescription(row.getString("description"));

        review.setStars(row.getInt("stars"));

        return review;
    }
}
