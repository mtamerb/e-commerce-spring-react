package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.config.ApiResponse;
import com.tamerb.ecommerce.model.Category;
import com.tamerb.ecommerce.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("api/category")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody Category category) {
        if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
            return new ResponseEntity<>(new ApiResponse("Category already exists", false), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse("Category created successfully", true), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Category>> getCategories(){
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @PostMapping("/update/{categoryID}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Integer categoryID, @Valid @RequestBody Category category) {
        if(Objects.nonNull(categoryService.readCategory(categoryID))){
            categoryService.updateCategory(categoryID, category);
            return new ResponseEntity<>(new ApiResponse("Category updated successfully", true), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse("Category not found", false), HttpStatus.NOT_FOUND);

    }










}
