package com.techelevator.reservations.dao;

import com.techelevator.reservations.model.Reward;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcRewardDao implements RewardDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcRewardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Reward createOrUpdate(int points, String username) {
        String sql = "INSERT INTO reward (user_id, points) " +
                "VALUES ((SELECT user_id FROM \"user\" WHERE username = ?), ?) " +
                "ON CONFLICT (user_id) DO " +
                "UPDATE SET points = reward.points + ? " +
                "WHERE reward.user_id = (SELECT user_id FROM \"user\" WHERE username = ?);";

        jdbcTemplate.update(sql, username, points, points, username);

        Reward reward = new Reward();
        reward.setPoints(points);
        return reward;
    }
}
