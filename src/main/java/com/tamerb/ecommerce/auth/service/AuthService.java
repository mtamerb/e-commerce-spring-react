package com.tamerb.ecommerce.auth.service;


import com.tamerb.ecommerce.auth.request.LoginRequest;
import com.tamerb.ecommerce.auth.request.SignUpRequest;
import com.tamerb.ecommerce.auth.response.AuthResponse;
import com.tamerb.ecommerce.entities.User;
import com.tamerb.ecommerce.repository.UserRepository;
import com.tamerb.ecommerce.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import static com.tamerb.ecommerce.enums.Role.ADMIN;
import static com.tamerb.ecommerce.enums.Role.USER;


@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;


    public AuthResponse register(SignUpRequest registerRequest) {

        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            return new AuthResponse("User with this email already exists", HttpStatus.BAD_REQUEST);
        }

        User user = User.builder()
                .firstName(registerRequest.getFirstName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(new BCryptPasswordEncoder().encode(registerRequest.getPassword()))
                .role(USER)
                .build();

        userRepository.save(user);

        return AuthResponse.builder()
                .message("User registered successfully")
                .response(HttpStatus.OK)
                .build();
    }

    public AuthResponse login(LoginRequest loginRequest) {

        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(user);

        String message = user.getRole().equals(ADMIN) ? "Admin logged in successfully" : "User logged in successfully";

        return AuthResponse.builder()
                .message(message)
                .response(HttpStatus.OK)
                .token(token)
                .build();
    }


}
