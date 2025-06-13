package com.example.product.inventory.Repository;

import com.example.product.inventory.Entity.InventoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<InventoryEntity,Long> {

}
