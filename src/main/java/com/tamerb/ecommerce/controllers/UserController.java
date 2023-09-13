package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.business.services.UserService;
import com.tamerb.ecommerce.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> userList() {
        return ResponseEntity.ok(userService.listAllUser());
    }


}
