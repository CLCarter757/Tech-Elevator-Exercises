package com.techelevator;

import com.techelevator.dao.JdbcMovieDao;
import com.techelevator.dao.MovieDao;
import org.apache.commons.dbcp2.BasicDataSource;

public class Application {

    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql//localhost:5432/MovieDB");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        MovieDao dao = new JdbcMovieDao(dataSource);
        MovieCLI cli = new MovieCLI(dao);

        cli.run();
    }
}
