package com.springmicroservices.productservice.service;

import com.springmicroservices.productservice.Repository.ProductRepository;
import com.springmicroservices.productservice.dto.ProductRequest;
import com.springmicroservices.productservice.dto.ProductResponse;
import com.springmicroservices.productservice.model.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest)
    {
        Product product=Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved",product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> productlist = productRepository.findAll();
        System.out.println("list");
        return productlist.stream().map(this::maptoProductResponse).toList();

    }

    private ProductResponse maptoProductResponse(Product product) {
        return ProductResponse.builder()
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .id(product.getId())
                .build();
    }
}
