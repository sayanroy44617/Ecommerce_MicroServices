package com.example.orderservice.service;

import com.example.orderservice.dto.InventoryResponse;
import com.example.orderservice.dto.OrderLineItemsDto;
import com.example.orderservice.dto.OrderRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.OrderLineItem;
import com.example.orderservice.repository.OrderSpringJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class OrderService {

    private OrderSpringJpaRepository orderSpringJpaRepository;
    private final WebClient.Builder webClientBuilder;
    public void createOrders(OrderRequest orderRequest)
    {
        Order order=new Order();
        order.setOrdername(UUID.randomUUID().toString());


        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItemList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemList(orderLineItems);

        //before sending the order we need to verify if the inventory
        //exists or not

        List<String> skuCodes = order.getOrderLineItemList().stream()
                .map(OrderLineItem::getSkucode).toList();


        InventoryResponse[] responses = webClientBuilder.build().get()
                .uri("http://inventory-service/api/inventory",uriBuilder ->
                        uriBuilder.queryParam("skuCode",skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(responses)
                .allMatch(InventoryResponse::isInStock);

        if(allProductsInStock) {
            orderSpringJpaRepository.save(order);
        }
        else {
            throw new IllegalArgumentException("Product not in stock");
        }
    }

    private OrderLineItem mapToDto(OrderLineItemsDto orderLineItemRequest) {
        OrderLineItem orderLineItem=new OrderLineItem();
        orderLineItem.setQuantity(orderLineItemRequest.getQuantity());
        orderLineItem.setPrice(orderLineItemRequest.getPrice());
        orderLineItem.setSkucode(orderLineItemRequest.getSkucode());

        return orderLineItem;
    }
}
