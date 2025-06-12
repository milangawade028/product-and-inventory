package com.example.product.inventory.Service;

import com.example.product.inventory.Dto.ProductDto;
import com.example.product.inventory.Entity.ProductEntity;
import com.example.product.inventory.Repository.ProductRepo;
import com.example.product.inventory.exception.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;
    public ProductEntity AddProduct(ProductDto productDto) {
        ProductEntity productEntity=new ProductEntity();
        productEntity.setProductId(0L);
        productEntity.setProductName(productDto.getProductName());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setCategory(productDto.getCategory());
        productEntity.setUnit(productDto.getUnit());

        productEntity.setCreatedBy(productDto.getCreatedBy());
        productEntity.setCreatedDate(LocalDateTime.now());
        productEntity.setUpdatedBy(productDto.getUpdatedBy());
        productEntity.setUpdatedDate(LocalDateTime.now());

        return productRepo.save(productEntity);
    }


    public List<ProductEntity> getAllProduct(){
        List<ProductEntity> productEntityList=productRepo.findAll();
        return productEntityList;
    }


    public ProductEntity getById(Long productId){
        ProductEntity productEntity=productRepo.findById(productId).orElseThrow(()->new ProductNotFoundException("product not found"));
        return productEntity;
    }

    public void deleteById(Long productId){
        if(!productRepo.existsById(productId)){
            throw new ProductNotFoundException("can not delete:Product not found");
        }
        productRepo.deleteById(productId);

    }

    public ProductEntity updateProduct(Long productId,ProductDto productDto) {
        ProductEntity productEntity = productRepo.findById(productId).orElseThrow(()->new ProductNotFoundException("product with"+productId+"not found"));
        productEntity.setProductName(productDto.getProductName());
        productEntity.setDescription(productDto.getDescription());
        productEntity.setPrice(productDto.getPrice());
        productEntity.setCategory(productDto.getCategory());
        productEntity.setUnit(productDto.getUnit());
        return productRepo.save(productEntity);
    }
}
