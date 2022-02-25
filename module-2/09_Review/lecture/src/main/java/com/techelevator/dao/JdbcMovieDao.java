package com.techelevator.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class JdbcMovieDao implements MovieDao{
    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


}
