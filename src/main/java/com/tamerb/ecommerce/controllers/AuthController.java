package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.auth.request.LoginRequest;
import com.tamerb.ecommerce.auth.response.AuthResponse;
import com.tamerb.ecommerce.auth.request.SignUpRequest;
import com.tamerb.ecommerce.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequiredArgsConstructor
@RestController
@RequestMapping("auth")
public class AuthController {


    private final AuthService authenticationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponse> signUp(@Valid @RequestBody SignUpRequest signUpRequest) {
        return ResponseEntity.ok(authenticationService.register(signUpRequest));
    }

    @PostMapping("/sign-in")
    public ResponseEntity<AuthResponse> signin(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(authenticationService.login(loginRequest));
    }

}