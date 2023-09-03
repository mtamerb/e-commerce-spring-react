package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.dto.RegisterDto;
import com.tamerb.ecommerce.dto.ResponseDto;
import com.tamerb.ecommerce.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor

@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseDto register(@RequestBody RegisterDto registerDto) {
        return userService.register(registerDto);
    }

}
