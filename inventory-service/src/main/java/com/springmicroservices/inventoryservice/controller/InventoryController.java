package com.springmicroservices.inventoryservice.controller;

import com.springmicroservices.inventoryservice.responsedto.InventoryResponse;
import com.springmicroservices.inventoryservice.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {
    private final InventoryService inventoryService;

    //controller to verify if the product is in stock or not
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode)
    {
        System.out.println(skuCode);
        return inventoryService.isInStock(skuCode);
    }
}
