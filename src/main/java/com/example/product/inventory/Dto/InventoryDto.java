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



        public Long getProductId() {
                return productId;
        }

        public void setProductId(Long productId) {
                this.productId = productId;
        }

        public int getAvailableQuantity() {
                return availableQuantity;
        }

        public void setAvailableQuantity(int availableQuantity) {
                this.availableQuantity = availableQuantity;
        }

        public LocalDateTime getLastUpdated() {
                return lastUpdated;
        }

        public void setLastUpdated(LocalDateTime lastUpdated) {
                this.lastUpdated = lastUpdated;
        }
}

