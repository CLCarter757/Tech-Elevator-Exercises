package com.techelevator.sqlinjectiondemo.dao;

import com.techelevator.userdemo.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcUserDao implements UserDao {
    private final JdbcTemplate jdbcTemplate;

    public JdbcUserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public User findUser(String username) {
        String sql = "SELECT id, username FROM users WHERE username = '" + username + "';"; // DON'T DO THIS!!

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql);

        if(result.next()) {
            User user = new User();
            user.setId(result.getLong("id"));
            user.setUsername(result.getString("username"));
            return user;
        }

        return null;
    }
}
