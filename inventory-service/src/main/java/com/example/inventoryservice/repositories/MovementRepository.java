package com.example.inventoryservice.repositories;

import com.example.inventoryservice.models.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface MovementRepository extends JpaRepository<StockMovement, Long> {
    List<StockMovement> findAllByCreatedDate(Date date);
}
