package com.techelevator.reservations.security.repository;

import com.techelevator.reservations.security.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Primary
public class UserSqlDao implements UserDao {

    private static final double STARTING_BALANCE = 1000;
    private final JdbcTemplate jdbcTemplate;

    public UserSqlDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Optional<User> findByUsername(String username) {
        verifyUsername(username);

        String sql = "select * from \"user\" where username = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, username);
        if(result.next()) {
            User user = mapRowToUser(result);

            addAuthoritiesToUser(user);

            return Optional.of(user);
        }

        String message = getMissingUserMessage(username);
        throw new UsernameNotFoundException(message);
    }

    private void addAuthoritiesToUser(User user) {
        String sql = "select authority_name from user_authority where user_id = ?;";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, user.getId());
        while(result.next()) {
            user.addAuthority(result.getString("authority_name"));
        }
    }


    private User mapRowToUser(SqlRowSet rs) {

        Long userId = rs.getLong("user_id");
        String username = rs.getString("username");
        String password = rs.getString("password_hash");
        boolean isActive = true;

        return new User(userId, username, password, null, isActive);
    }

    private void verifyUsername(String username) {
        if(username == null) {
            throw new IllegalArgumentException("username cannot be null.");
        }
    }

    private String getMissingUserMessage(String username) {
        return "User " + username + " was not found.";
    }
}
