package com.example.inventoryservice.repositories;

import com.example.inventoryservice.models.Product;
import com.example.inventoryservice.models.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
