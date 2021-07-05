package com.example.inventoryservice.services;

import com.example.inventoryservice.dtos.CreateStockMovementDto;
import com.example.inventoryservice.dtos.StockMovementDto;
import com.example.inventoryservice.models.StockMovement;

import java.util.Date;
import java.util.List;

public interface MovementService {
    StockMovementDto createStockMovement(CreateStockMovementDto stockMovement);
    List<StockMovementDto> getStockMovementsByDate(Date date);
}
