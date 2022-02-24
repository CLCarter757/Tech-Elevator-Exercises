package com.techelevator.sqlinjectiondemo;

import com.techelevator.sqlinjectiondemo.dao.JdbcUserDao;
import com.techelevator.userdemo.model.User;

import javax.sql.DataSource;
import java.util.Scanner;

public class SqlInjectionCLI {
    private final JdbcUserDao poorlyImplementedUserDao;

    public SqlInjectionCLI(DataSource dataSource) {
        this.poorlyImplementedUserDao = new JdbcUserDao(dataSource);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the user id you'd like to search for >>>");

        String userInput = scanner.nextLine();

        User userFound = poorlyImplementedUserDao.findUser(userInput);

        if(userFound == null) {
            System.out.println("No user was found.");
        } else {
            System.out.println("Found a user: " + userFound.getUsername());
        }
    }
}
