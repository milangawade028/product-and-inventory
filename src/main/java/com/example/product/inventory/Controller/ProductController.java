package com.example.product.inventory.Controller;

import com.example.product.inventory.Dto.ProductDto;
import com.example.product.inventory.Entity.ProductEntity;
import com.example.product.inventory.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/product")
public class ProductController {
@Autowired
  private   ProductService productService;

    @PostMapping("/addProduct")
    public ResponseEntity<ProductEntity> AddProduct(@RequestBody ProductDto productDto){
        return new ResponseEntity<>(productService.AddProduct(productDto), CREATED);
    }

    @GetMapping ("/getAllProduct")
    public ResponseEntity<List<ProductEntity>> getAllProduct(){
        List<ProductEntity> productEntity= productService.getAllProduct();
        return new ResponseEntity<>(productEntity, CREATED);
    }

    @GetMapping("/getById/{productId}")
    public ResponseEntity<ProductEntity> getProductById(@PathVariable Long productId)
    {
        ProductEntity productEntity=productService.getById(productId);
        return new ResponseEntity<>(productEntity,OK);
    }

    @DeleteMapping("{productId}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Long productId)
    {
        productService.deleteById(productId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/updateProduct/{productId}")
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductDto productDto,@PathVariable Long productId)
    {
        ProductEntity productEntity=productService.updateProduct(productId,productDto);
        return ResponseEntity.ok(productEntity);
    }


}
