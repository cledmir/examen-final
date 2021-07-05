package com.example.inventoryservice.dtos;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStockMovementDto {
    private Long quantity;
    private Date createdDate;
    private Long productId;
}
