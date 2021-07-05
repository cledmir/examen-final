package com.example.inventoryservice.services.Impl;

import com.example.inventoryservice.dtos.CreateStockMovementDto;
import com.example.inventoryservice.dtos.StockMovementDto;
import com.example.inventoryservice.exceptions.NotFoundException;
import com.example.inventoryservice.models.Product;
import com.example.inventoryservice.models.StockMovement;
import com.example.inventoryservice.repositories.MovementRepository;
import com.example.inventoryservice.repositories.ProductRepository;
import com.example.inventoryservice.services.MovementService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementServiceImpl implements MovementService {

    @Autowired
    MovementRepository movementRepository;

    @Autowired
    ProductRepository productRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public StockMovementDto createStockMovement(CreateStockMovementDto createStockMovement) {

        StockMovement stockMovement = new StockMovement();
        Product product = productRepository.findById(createStockMovement.getProductId()
        ).orElseThrow(()-> new NotFoundException("Not found"));

        stockMovement.setProduct(product);
        stockMovement.setCreatedDate(createStockMovement.getCreatedDate());
        stockMovement.setQuantity(createStockMovement.getQuantity());
        return convertToResource(movementRepository.save(stockMovement));
    }

    @Override
    public List<StockMovementDto> getStockMovementsByDate(Date date) {
        return convertToResources(movementRepository.findAllByCreatedDate(date));
    }


    private List<StockMovementDto> convertToResources(List<StockMovement> entity) {
        return entity.stream().map(x -> modelMapper.map(x, StockMovementDto.class)).collect(Collectors.toList());
    }

    private StockMovementDto convertToResource(StockMovement entity){return  modelMapper.map(entity,StockMovementDto.class);}
}
