package com.techelevator.dao;

import com.techelevator.dao.users.JdbcUserDAO;
import com.techelevator.model.users.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class UserSqlDaoIntegrationTest extends DAOIntegrationTest {

    private JdbcUserDAO userSqlDAO;

    @Before
    public void setup() {
        DataSource dataSource = this.getDataSource();
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        userSqlDAO = new JdbcUserDAO(jdbcTemplate);
    }

    @Test
    public void createNewUser() {
        boolean userCreated = userSqlDAO.create("TEST_USER","test_password","user");
        Assert.assertTrue(userCreated);
        User user = userSqlDAO.findByUsername("TEST_USER");
        Assert.assertEquals("TEST_USER", user.getUsername());
    }

}
