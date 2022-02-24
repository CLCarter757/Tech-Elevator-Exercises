package com.techelevator.sqlinjectiondemo;

import org.apache.commons.dbcp2.BasicDataSource;

public class Application {
    public static void main(String[] args) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/user-manager");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");

        SqlInjectionCLI application = new SqlInjectionCLI(dataSource);
        application.run();
    }
}
