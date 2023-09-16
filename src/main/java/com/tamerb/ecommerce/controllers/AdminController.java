package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.business.services.CategoryService;
import com.tamerb.ecommerce.business.services.UserService;
import com.tamerb.ecommerce.config.ApiResponse;
import com.tamerb.ecommerce.entities.Category;
import com.tamerb.ecommerce.entities.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("admin")
public class AdminController {


    // USER

    private final UserService userService;
    private final CategoryService categoryService;


    @GetMapping("/user/list")
    public ResponseEntity<List<User>> userList() {
        return ResponseEntity.ok(userService.listAllUser());
    }

    @DeleteMapping("/user/delete/{id}")
    public ResponseEntity<ApiResponse> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(new ApiResponse(true, "User deleted successfully. ID: " + id));
    }

    @DeleteMapping("/user/delete/all")
    public ResponseEntity<ApiResponse> deleteAllUser() {
        userService.deleteAllUser();
        return ResponseEntity.ok(new ApiResponse(true, "All user deleted successfully"));
    }





}
