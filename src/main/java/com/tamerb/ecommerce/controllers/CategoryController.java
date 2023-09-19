package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.business.dto.CategoryDto;
import com.tamerb.ecommerce.common.ApiResponse;
import com.tamerb.ecommerce.entities.Category;
import com.tamerb.ecommerce.business.services.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
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

    @Operation(summary = "Create a category")
    @PostMapping("")
    public ResponseEntity<ApiResponse> createCategory(@Valid @RequestBody CategoryDto categoryDto) {
        if (Objects.nonNull(categoryService.readCategory(categoryDto.getCategoryName()))) {
            return new ResponseEntity<>(new ApiResponse(false, "Category already exists"), HttpStatus.CONFLICT);
        }
        categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(new ApiResponse(true, "Category created successfully"), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all categories")
    @GetMapping("")
    public ResponseEntity<List<Category>> getCategories() {
        List<Category> body = categoryService.listCategories();
        return new ResponseEntity<>(body, HttpStatus.OK);
    }

    @Operation(summary = "Update a category by ID")
    @PutMapping("/{categoryID}")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryID") Long categoryID,
                                                      @Valid @RequestBody CategoryDto categoryDto) {
        if (Objects.nonNull(categoryService.readCategory(categoryID))) {
            categoryService.updateCategory(categoryID, categoryDto);
            return new ResponseEntity<>(new ApiResponse(true, "Category updated successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "Category not found"), HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Delete a category by ID")
    @DeleteMapping("/{categoryID}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryID") Long categoryID){
        if(Objects.nonNull(categoryService.readCategory(categoryID))){
            categoryService.deleteCategory(categoryID);
            return new ResponseEntity<>(new ApiResponse(true, "Category deleted successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "Category not found"), HttpStatus.NOT_FOUND);
    }


    @Operation(summary = "Delete all categories")
    @DeleteMapping("")
    public ResponseEntity<ApiResponse> deleteAll(){
        if(Objects.nonNull(categoryService.listCategories())){
            categoryService.deleteAllCategory();
            return new ResponseEntity<>(new ApiResponse(true, "Category deleted successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "Categories empty"), HttpStatus.NOT_FOUND);
    }
}
