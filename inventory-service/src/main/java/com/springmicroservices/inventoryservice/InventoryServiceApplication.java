package com.springmicroservices.inventoryservice;

import com.springmicroservices.inventoryservice.model.Inventory;
import com.springmicroservices.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableDiscoveryClient
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run( InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return (args) -> {
			Inventory inventory1 = new Inventory();
			Inventory inventory2 = new Inventory();

			inventory2.setSkuCode("Iphone 13");
			inventory2.setQuantity(0);

			inventory1.setSkuCode("Dell Laptop");
			inventory1.setQuantity(12);

			inventoryRepository.save(inventory1);
			inventoryRepository.save(inventory2);
		};

	}

}
