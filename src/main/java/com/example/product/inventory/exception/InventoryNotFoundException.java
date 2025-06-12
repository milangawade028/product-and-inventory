package com.example.product.inventory.exception;

public class InventoryNotFoundException extends RuntimeException{

    public InventoryNotFoundException(String message) {
        super(message);
    }
}
