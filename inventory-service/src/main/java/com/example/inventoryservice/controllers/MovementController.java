package com.example.inventoryservice.controllers;

import com.example.inventoryservice.dtos.CreateStockMovementDto;
import com.example.inventoryservice.dtos.StockMovementDto;
import com.example.inventoryservice.responses.ResourceResponse;
import com.example.inventoryservice.services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import java.text.ParseException;

@RestController
@RequestMapping(path = "/movements")
public class MovementController {
    @Autowired
    MovementService movementService;

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("movementsByDate")
    public ResourceResponse<List<StockMovementDto>> getMovementsByDate(Date date) throws RuntimeException{
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                movementService.getStockMovementsByDate(date));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("movements")
    public ResourceResponse<StockMovementDto> createCard(@RequestBody @Valid CreateStockMovementDto createCardDto ) throws ParseException {
        return new ResourceResponse<>("Success",String.valueOf(HttpStatus.OK),"OK",
                movementService.createStockMovement(createCardDto));
    }

}
