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


    // CATEGORY


    @PostMapping("/category/create")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
            return new ResponseEntity<>(new ApiResponse(false, "Category already exists"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true, "Category created successfully"), HttpStatus.CREATED);
    }

    @GetMapping("/category/list")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/category/update/{categoryID}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Long categoryID, @Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.readCategory(categoryID))) {
            categoryService.updateCategory(categoryID, category);
            return new ResponseEntity<>(new ApiResponse(true, "Category updated successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "Category not found"), HttpStatus.NOT_FOUND);

    }


    // PRODUCT


}
