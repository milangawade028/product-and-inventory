package com.example.product.inventory.Dto;

import com.example.product.inventory.Entity.InventoryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryDto {


        private Long productId;
        private int availableQuantity;
        private LocalDateTime lastUpdated;

        private boolean isActive;
        private String createdBy;
        private LocalDateTime createdDate;
        private String updatedBy;
        private LocalDateTime updatedDate;


}

