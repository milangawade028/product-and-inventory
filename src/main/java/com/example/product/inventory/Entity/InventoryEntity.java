package com.example.product.inventory.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
@Entity
@Data
@Getter
@Setter
@NoArgsConstructor

@Table(name="Inventory")
public class InventoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotNull(message = "Product id is required")
    @Min(value = 1,message = "Product id must be greater than zero")
    private Long productId;

    @NotNull(message = "quantity is required")
    @Min(value = 0,message = "quantity cannot be negative")
    private int availableQuantity;
    private LocalDateTime lastUpdated;


    @OneToOne
    @JoinColumn(name = "product_id",nullable = false,unique = true)
    private ProductEntity productEntity;

    public @NotNull(message = "Product id is required") @Min(value = 1, message = "Product id must be greater than zero") Long getProductId() {
        return productId;
    }

    public void setProductId(@NotNull(message = "Product id is required") @Min(value = 1, message = "Product id must be greater than zero") Long productId) {
        this.productId = productId;
    }

    @NotNull(message = "quantity is required")
    @Min(value = 0, message = "quantity cannot be negative")
    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(@NotNull(message = "quantity is required") @Min(value = 0, message = "quantity cannot be negative") int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }
}
