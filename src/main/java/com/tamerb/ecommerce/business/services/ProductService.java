package com.tamerb.ecommerce.business.services;

import com.tamerb.ecommerce.business.dto.ProductDto;
import com.tamerb.ecommerce.entities.Category;
import com.tamerb.ecommerce.entities.Product;
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



    public List<ProductDto> listProducts() {
        List<Product> products = productRepository.findAll();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            productDtos.add(new ProductDto(product));
        }
        return productDtos;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public void deleteAllProduct() {
        productRepository.deleteAll();
    }

    public Object readProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }


    public void createProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setPrice(productDto.getPrice());
        product.setImageUrl(productDto.getImageURL());
        product.setCategory(category);
        productRepository.save(product);
    }
}
