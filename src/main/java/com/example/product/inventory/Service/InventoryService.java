package com.example.product.inventory.Service;

import com.example.product.inventory.Dto.InventoryDto;
import com.example.product.inventory.Entity.InventoryEntity;
import com.example.product.inventory.Entity.ProductEntity;
import com.example.product.inventory.Repository.InventoryRepo;
import com.example.product.inventory.Repository.ProductRepo;
import com.example.product.inventory.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class InventoryService {
    @Autowired
    InventoryRepo inventoryRepo;
    @Autowired
    ProductRepo productRepo;
    public InventoryEntity addInventory(InventoryDto inventoryDto) {


        ProductEntity product = productRepo.findById(inventoryDto.getProductId())
                .orElseThrow(() -> new ProductNotFoundException("Product not found with ID: " + inventoryDto.getProductId()));


        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setAvailableQuantity(inventoryDto.getAvailableQuantity());
        inventoryEntity.setLastUpdated(inventoryDto.getLastUpdated());

        inventoryEntity.setCreatedBy(inventoryDto.getCreatedBy());
        inventoryEntity.setCreatedDate(LocalDateTime.now());
        inventoryEntity.setUpdatedBy(inventoryDto.getUpdatedBy());
        inventoryEntity.setUpdatedDate(LocalDateTime.now());


        inventoryEntity.setProductEntity(product);


        return inventoryRepo.save(inventoryEntity);
    }

    public List<InventoryEntity> viewAllInventory() {
        List<InventoryEntity> inventoryEntity = inventoryRepo.findAll();
        return inventoryEntity;

    }
    public InventoryEntity updateQuantity(Long productId, InventoryDto inventoryDto) {
        ProductEntity productEntity=productRepo.findById(productId).orElseThrow(()->new ProductNotFoundException("product not found"));
        InventoryEntity inventoryEntity=new InventoryEntity();
        inventoryEntity.setAvailableQuantity(inventoryDto.getAvailableQuantity());
        inventoryEntity.setLastUpdated(inventoryDto.getLastUpdated());

        inventoryEntity.setUpdatedBy(inventoryDto.getUpdatedBy());
        inventoryEntity.setUpdatedDate(LocalDateTime.now());

        return inventoryRepo.save(inventoryEntity);

    }
}
