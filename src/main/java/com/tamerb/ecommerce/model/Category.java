package com.tamerb.ecommerce.model;


    import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryID;

    @NotBlank
    @Column(name = "category_name")
    private String categoryName;

    @NotBlank
    private String description;

    @NotBlank
    private String imageUrl;

    public Category() {
    }

    public Category(@NotBlank String categoryName, @NotBlank String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    public Category(@NotBlank Integer categoryID, @NotBlank String categoryName,
                    @NotBlank String description, @NotBlank String imageUrl) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Category [id=" + categoryID + ", categoryName=" + categoryName + ", description=" +
                description + ", imageUrl=" + imageUrl + "]";
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
