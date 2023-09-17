package com.tamerb.ecommerce.business.services;

import com.tamerb.ecommerce.business.dto.ProductDto;
import com.tamerb.ecommerce.entities.Category;
import com.tamerb.ecommerce.entities.Product;
import com.tamerb.ecommerce.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> listProducts() {
        return productRepository.findAll();
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
        product.setCategoryID(category.getId());
        product.setCategory(category);
        productRepository.save(product);
    }

    public void updateProduct(Long productID, ProductDto productDto) {
        Product product = productRepository.findById(productID).orElse(null);
        if (product != null) {
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            product.setImageUrl(productDto.getImageURL());
            productRepository.save(product);
        } else {
            log.error("Product not found with id: " + productID + " to update");
        }
    }
}
