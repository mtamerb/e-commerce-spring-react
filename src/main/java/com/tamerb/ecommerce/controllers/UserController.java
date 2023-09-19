package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.business.services.UserService;
import com.tamerb.ecommerce.common.ApiResponse;
import com.tamerb.ecommerce.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/all")
    public ResponseEntity<List<User>> userList() {
        return ResponseEntity.ok(userService.listAllUser());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse(true, "User deleted successfully. ID: " + id));
    }
}
