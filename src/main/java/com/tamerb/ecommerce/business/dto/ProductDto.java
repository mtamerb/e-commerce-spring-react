package com.tamerb.ecommerce.business.dto;

import com.tamerb.ecommerce.entities.Product;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class ProductDto {
    private Long productId;
    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull Integer categoryId;

    public ProductDto(Long productId, String name, String imageURL, double price, String description, Integer categoryId) {
        this.productId = productId;
        this.name = name;
        this.imageURL = imageURL;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }

    public ProductDto(Product product) {
    }
}
