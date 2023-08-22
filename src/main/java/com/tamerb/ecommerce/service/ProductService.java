package com.tamerb.ecommerce.service;

import com.tamerb.ecommerce.dto.ProductDto;
import com.tamerb.ecommerce.model.Category;
import com.tamerb.ecommerce.model.Product;
import com.tamerb.ecommerce.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private Product getProductFromDto(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setImageUrl(productDto.getImageURL());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        product.setDescription(productDto.getDescription());
        return product;
    }

    public void addProduct(ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        productRepository.save(product);
    }

    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();

        for (Product product : products) {
            productDtos.add(new ProductDto(product));
        }
        return productDtos;
    }

    public void updateProduct(Integer productId, ProductDto productDto, Category category) {
        Product product = getProductFromDto(productDto, category);
        product.setId(productId);
        productRepository.save(product);
    }
}
