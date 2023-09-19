package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.common.ApiResponse;
import com.tamerb.ecommerce.business.dto.ProductDto;
import com.tamerb.ecommerce.entities.Category;
import com.tamerb.ecommerce.business.services.CategoryService;
import com.tamerb.ecommerce.business.services.ProductService;
import com.tamerb.ecommerce.entities.Product;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("api/product")
public class ProductController {


    private final ProductService productService;
    private final CategoryService categoryService;


    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @Operation(summary = "Get all products")
    @GetMapping("")
    public ResponseEntity<List<Product>> listProducts() {
        return new ResponseEntity<>(productService.listProducts(), HttpStatus.OK);
    }

    @Operation(summary = "Create a product")
    @PostMapping("{categoryID}")
    public ResponseEntity<ApiResponse> createProduct(@PathVariable("categoryID") Long categoryID, @Valid @RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(categoryID);
        if (optionalCategory.isPresent()) {
            Category category = optionalCategory.get();
            productService.createProduct(productDto, category);
            return new ResponseEntity<>(new ApiResponse(true, "Product created successfully"), HttpStatus.CREATED);
        }
        return new ResponseEntity<>(new ApiResponse(false, "Category not found"), HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Update a product by ID")
    @PutMapping("{productID}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productID") Long productID, @Valid @RequestBody ProductDto productDto) {
        if (Objects.nonNull(productService.readProduct(productID))) {
            productService.updateProduct(productID, productDto);
            return new ResponseEntity<>(new ApiResponse(true, "Product updated successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "Product not found"), HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Delete a product by ID")
    @DeleteMapping("/{productID}")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable("productID") Long productID) {
        if (Objects.nonNull(productService.readProduct(productID))) {
            productService.deleteProduct(productID);
            return new ResponseEntity<>(new ApiResponse(true, "Product deleted successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "Product not found"), HttpStatus.NOT_FOUND);
    }

    @Operation(summary = "Delete All products")
    @DeleteMapping("")
    public ResponseEntity<ApiResponse> deleteAll() {
        if (Objects.nonNull(productService.listProducts())) {
            productService.deleteAllProduct();
            return new ResponseEntity<>(new ApiResponse(true, "Product deleted successfully"), HttpStatus.OK);
        }
        return new ResponseEntity<>(new ApiResponse(false, "Products empty"), HttpStatus.NOT_FOUND);
    }

}
