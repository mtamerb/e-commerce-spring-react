package com.tamerb.ecommerce.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private @NotNull String name;

    private @NotNull String imageUrl;

    private @NotNull double price;

    private @NotNull String description;

    private @NotNull Long categoryID;

    @JsonIgnore
    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    Category category;

    public Product(String name, String imageUrl, double price, String description, Category category) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.price = price;
        this.description = description;
        this.category = category;
    }

    public Product() {

    }


}
