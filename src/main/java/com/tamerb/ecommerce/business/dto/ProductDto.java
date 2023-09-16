package com.tamerb.ecommerce.business.dto;

import com.tamerb.ecommerce.entities.Product;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;


@Getter
@Setter

public class ProductDto {
    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    private @NotNull String description;

    public ProductDto(Product product) {
    }
}
