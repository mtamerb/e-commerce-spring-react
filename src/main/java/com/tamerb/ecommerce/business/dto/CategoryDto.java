package com.tamerb.ecommerce.business.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CategoryDto {

    private @NotNull String categoryName;
    private @NotNull String description;
    private @NotNull String imageUrl;

}
