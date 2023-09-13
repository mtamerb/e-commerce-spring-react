package com.tamerb.ecommerce.config;

import com.tamerb.ecommerce.entities.User;
import com.tamerb.ecommerce.enums.Role;
import com.tamerb.ecommerce.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class InitAdminConfig implements CommandLineRunner {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {
            try {
                User admin = User.builder()
                        .firstName("admin")
                        .username("admin")
                        .password(passwordEncoder.encode("admin"))
                        .email("tamerbilici00@gmail.com")
                        .role(Role.ADMIN)
                        .build();
                userRepository.save(admin);
                log.info("ADMIN user created - {}", admin.getUsername());
            } catch (Exception e) {
                log.error("Error creating ADMIN user", e);
            }
        }
    }

}
