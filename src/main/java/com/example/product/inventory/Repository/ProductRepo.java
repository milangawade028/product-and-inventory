package com.example.product.inventory.Repository;

import com.example.product.inventory.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<ProductEntity,Long> {


}
