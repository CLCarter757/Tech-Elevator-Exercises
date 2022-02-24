package com.techelevator.sqlinjectiondemo.dao;

import com.techelevator.userdemo.model.User;

public interface UserDao {
    /**
     * Get a user from the database.
     * @return a User
     */
    User findUser(String username);
}
