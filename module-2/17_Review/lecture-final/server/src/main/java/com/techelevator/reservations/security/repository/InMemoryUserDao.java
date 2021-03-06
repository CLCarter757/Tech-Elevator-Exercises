package com.techelevator.reservations.security.repository;

import com.techelevator.reservations.security.model.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class InMemoryUserDao implements UserDao {

    private final String USERS_DATA_FILE = "users.txt";
    private static List<User> users = new ArrayList<>();

    public InMemoryUserDao() {
        if (users.isEmpty()) {
            setUsers();
        }
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return users.stream().filter(user -> user.getUsername().equals(username)).findFirst();
    }

    private void setUsers() {
        Resource resource = loadUsers();
        if (resource.exists()) {
            try {
                Stream<String> lines = Files.lines(resource.getFile().toPath());
                lines.forEach(line -> {
                    String[] userDetails = line.split(",");
                    users.add(new User((Long.parseLong(userDetails[0])), userDetails[1], userDetails[2], userDetails[3], Boolean.parseBoolean(userDetails[4])));
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // setup 2 default users if the file does not exist
            users.add(new User(1L, "user", "password", "user", true));
            users.add(new User(2L, "admin", "password", "admin", true));
        }
    }

    private Resource loadUsers() {
        return new ClassPathResource(USERS_DATA_FILE);
    }

}
