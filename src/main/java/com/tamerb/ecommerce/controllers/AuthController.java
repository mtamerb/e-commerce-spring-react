package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.business.dto.AuthResponse;
import com.tamerb.ecommerce.business.dto.LoginRequest;
import com.tamerb.ecommerce.business.dto.SignUpRequest;
import com.tamerb.ecommerce.business.services.UserService;
import com.tamerb.ecommerce.entities.User;
import com.tamerb.ecommerce.exception.ResourceBadRequestException;
import com.tamerb.ecommerce.security.WebSecurityConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {

    private final UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest loginRequest) {
        Optional<User> userOptional = userService.validUsernameAndPassword(loginRequest.getUsername(), loginRequest.getPassword());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return ResponseEntity.ok(new AuthResponse(user.getId(), user.getName(), user.getRole()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public AuthResponse signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        if (userService.hasUserWithUsername(signUpRequest.getUsername())) {
            throw new ResourceBadRequestException(String.format("Username %s is already been used", signUpRequest.getUsername()));
        }
        if (userService.hasUserWithEmail(signUpRequest.getEmail())) {
            throw new ResourceBadRequestException(String.format("Email %s is already been used", signUpRequest.getEmail()));
        }

        User user = userService.saveUser(createUser(signUpRequest));
        return new AuthResponse(user.getId(), user.getName(), user.getRole());
    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        List<User> userList = userService.getUsers();
        return ResponseEntity.ok(userList);
    }


    private User createUser(SignUpRequest signUpRequest) {
        User user = new User();
        user.setUsername(signUpRequest.getUsername());
        user.setPassword(signUpRequest.getPassword());
        user.setName(signUpRequest.getName());
        user.setEmail(signUpRequest.getEmail());
        user.setRole(WebSecurityConfig.USER);
        return user;
    }
}