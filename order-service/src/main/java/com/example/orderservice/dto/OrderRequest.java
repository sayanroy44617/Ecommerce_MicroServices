package com.example.orderservice.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class OrderRequest {

    private List<OrderLineItemsDto> orderLineItemList;
}
