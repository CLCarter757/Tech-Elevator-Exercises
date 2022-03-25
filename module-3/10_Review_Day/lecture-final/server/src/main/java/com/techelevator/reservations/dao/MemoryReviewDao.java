package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Review;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemoryReviewDao implements ReviewDao {
    public static List<Review> reviews = new ArrayList<>();

    public MemoryReviewDao() {
        if (reviews.size() == 0) {
            setReviews();
        }
    }

    @Override
    public List<Review> getAll() {
        return reviews;
    }

    @Override
    public Review add(Review review) {
        reviews.add(review);

        return review;
    }


    private void setReviews() {
        reviews.add(new Review(
                "Mary Smith",
                "assets/img/user-1.png",
                "What a great product",
                "January 20, 2019 | 10:30 AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vehicula risus a magna volutpat placerat. Maecenas a mauris tempor, eleifend mi id, ultricies quam. Praesent a neque a ligula consequat mattis euismod ut ligula. Etiam ipsum felis, rhoncus nec tristique a, mattis vitae lectus. Nam sollicitudin interdum magna, vel finibus velit iaculis ac. Donec vehicula vitae nulla quis malesuada. Maecenas iaculis, lacus nec feugiat mollis, nunc elit bibendum elit, quis dignissim odio justo et est."));

        reviews.add(new Review(
                "John Smith",
                "assets/img/user-2.png",
                "I would recommend this product",
                "January 20, 2019 | 10:30 AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vehicula risus a magna volutpat placerat. Maecenas a mauris tempor, eleifend mi id, ultricies quam. Praesent a neque a ligula consequat mattis euismod ut ligula. Etiam ipsum felis, rhoncus nec tristique a, mattis vitae lectus. Nam sollicitudin interdum magna, vel finibus velit iaculis ac. Donec vehicula vitae nulla quis malesuada. Maecenas iaculis, lacus nec feugiat mollis, nunc elit bibendum elit, quis dignissim odio justo et est."));

        reviews.add(new Review(
                "Todd Smith",
                "assets/img/user-3.png",
                "I give it a 10 out of 10",
                "January 20, 2019 | 10:30 AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vehicula risus a magna volutpat placerat. Maecenas a mauris tempor, eleifend mi id, ultricies quam. Praesent a neque a ligula consequat mattis euismod ut ligula. Etiam ipsum felis, rhoncus nec tristique a, mattis vitae lectus. Nam sollicitudin interdum magna, vel finibus velit iaculis ac. Donec vehicula vitae nulla quis malesuada. Maecenas iaculis, lacus nec feugiat mollis, nunc elit bibendum elit, quis dignissim odio justo et est."));

        reviews.add(new Review(
                "Suzie Smith",
                "assets/img/user-4.png",
                "Exactly as advertised",
                "January 20, 2019 | 10:30 AM",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vehicula risus a magna volutpat placerat. Maecenas a mauris tempor, eleifend mi id, ultricies quam. Praesent a neque a ligula consequat mattis euismod ut ligula. Etiam ipsum felis, rhoncus nec tristique a, mattis vitae lectus. Nam sollicitudin interdum magna, vel finibus velit iaculis ac. Donec vehicula vitae nulla quis malesuada. Maecenas iaculis, lacus nec feugiat mollis, nunc elit bibendum elit, quis dignissim odio justo et est."));

    }
}
