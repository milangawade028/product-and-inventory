package com.example.product.inventory.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
@Entity
@Data
@Table(name="Inventory")
public class InventoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private int availableQuantity;
    private LocalDateTime lastUpdated;

    private boolean isActive;
    private String createdBy;
    private LocalDateTime createdDate;
    private String updatedBy;
    private LocalDateTime updatedDate;

    @OneToOne
    @JoinColumn(name = "product_id",nullable = false,unique = true)
    private ProductEntity productEntity;
}
