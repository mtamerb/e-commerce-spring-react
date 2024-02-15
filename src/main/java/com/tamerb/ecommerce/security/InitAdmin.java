package com.tamerb.ecommerce.security;


import com.tamerb.ecommerce.entities.User;
import com.tamerb.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import static com.tamerb.ecommerce.enums.Role.ADMIN;


@Slf4j
@Component
@RequiredArgsConstructor
public class InitAdmin implements CommandLineRunner {

    private final UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() == 0) {
            log.info("No user found, creating admin user");
            userRepository.save(
                    User.builder()
                            .firstName("Tamer")
                            .lastName("Bilici")
                            .email("tamerbilici@example.com")
                            .username("admin")
                            .password(new BCryptPasswordEncoder().encode("admin"))
                            .role(ADMIN)
                            .build());

        } else {
            log.warn("Admin user already exists");
        }

    }
}
