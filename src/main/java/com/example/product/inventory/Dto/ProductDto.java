package com.example.product.inventory.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ProductDto {

    @NotBlank(message ="Product name must not be blank")
    @Size(min=4,message="Description must not be blank")
    private String productName;
    private String description;

    @Min(0)
    @Positive(message="Price must not be zero")
    private double price;

    @NotBlank(message ="Category must not be blank")
    private String category;

    @NotBlank(message ="Unit must not be blank")
    private String unit;


    public @NotBlank(message = "Product name must not be blank") @Size(min = 4, message = "Description must not be blank") String getProductName() {
        return productName;
    }

    public void setProductName(@NotBlank(message = "Product name must not be blank") @Size(min = 4, message = "Description must not be blank") String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Min(0)
    @Positive(message = "Price must not be zero")
    public double getPrice() {
        return price;
    }

    public void setPrice(@Min(0) @Positive(message = "Price must not be zero") double price) {
        this.price = price;
    }

    public @NotBlank(message = "Category must not be blank") String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank(message = "Category must not be blank") String category) {
        this.category = category;
    }

    public @NotBlank(message = "Unit must not be blank") String getUnit() {
        return unit;
    }

    public void setUnit(@NotBlank(message = "Unit must not be blank") String unit) {
        this.unit = unit;
    }
}
