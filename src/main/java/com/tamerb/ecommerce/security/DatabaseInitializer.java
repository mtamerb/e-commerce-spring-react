package com.tamerb.ecommerce.security;

import com.tamerb.ecommerce.business.services.UserService;
import com.tamerb.ecommerce.entities.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class DatabaseInitializer implements CommandLineRunner {

    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {
        if (!userService.getUsers().isEmpty()) {
            log.info("There are already users in the database.");
            return;
        }

        USERS.forEach(userService::saveUser);
        log.info("Saved {} users to the database.", USERS.size());
    }

    private static final List<User> USERS = Arrays.asList(
            new User("admin", "admin", "Admin", "admin@mycompany.com", WebSecurityConfig.ADMIN)
    );
}
