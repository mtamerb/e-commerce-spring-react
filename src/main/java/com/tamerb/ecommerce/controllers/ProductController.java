package com.tamerb.ecommerce.controllers;

import com.tamerb.ecommerce.config.ApiResponse;
import com.tamerb.ecommerce.dto.ProductDto;
import com.tamerb.ecommerce.model.Category;
import com.tamerb.ecommerce.service.CategoryService;
import com.tamerb.ecommerce.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
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

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Category is invalid", false), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.addProduct(productDto, category);
        return new ResponseEntity<>(new ApiResponse("Product added successfully", true), HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getProducts() {
        List<ProductDto> productDtos = productService.listProducts();
        return new ResponseEntity<>(productDtos, HttpStatus.OK);
    }

    @PostMapping("/update/{productID}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("product_ID") Integer product_ID,
                                                     @RequestBody @Valid ProductDto productDto) {
        Optional<Category> optionalCategory = categoryService.readCategory(productDto.getCategoryId());
        if (optionalCategory.isEmpty()) {
            return new ResponseEntity<>(new ApiResponse("Category is invalid", false), HttpStatus.CONFLICT);
        }
        Category category = optionalCategory.get();
        productService.updateProduct(product_ID, productDto, category);
        return new ResponseEntity<>(new ApiResponse("Product updated successfully", true), HttpStatus.OK);

    }

}
