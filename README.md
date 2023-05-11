# **eCommerce Microservices Project**

This is a Java-based eCommerce microservices project built with Spring Boot. It implements various components for an online store, including Order Service, Inventory Service, Product Service, Discovery Service, and API Gateway. The project utilizes technologies like MySQL, MongoDB, Spring Cloud Eureka, Keycloak, and Spring Boot.

## **Components**
1. Order Service
The Order Service handles the management of customer orders. It provides functionality for creating, updating, and retrieving orders.

2. Inventory Service
The Inventory Service is responsible for managing the inventory of products. It allows tracking available stock, managing product quantities, and handling stock updates.

3. Product Service
The Product Service handles the management of products in the eCommerce system. It provides functionality for creating, updating, and retrieving product information.

4. Discovery Service
The Discovery Service, powered by Spring Cloud Eureka, acts as a service registry and discovery mechanism for the microservices. It enables service registration and allows services to locate and communicate with each other.

5. API Gateway
The API Gateway serves as the entry point for all incoming client requests. It acts as a single entry point, routing requests to the appropriate microservice based on the requested resource.

## **Technologies Used**
**Spring Boot** : A framework for creating stand-alone, production-grade Spring-based applications.

**MySQL** : A relational database management system used for storing and retrieving data related to the eCommerce system.

**MongoDB** : A NoSQL database used for flexible and scalable data storage, often employed for handling complex data models and unstructured data.

**Spring Cloud Eureka** : A service registry and discovery tool that facilitates communication between microservices by providing a centralized service registry.

**Keycloak** : An open-source identity and access management solution that provides secure authentication and authorization for the eCommerce system.

## Getting Started
To run the project locally, follow these steps:

Clone the repository:

bash
Copy code
``` git clone https://github.com/your/repository.git ```

## Configure the databases:

Set up a MySQL database and update the connection details in the project's configuration files.
Set up a MongoDB database and configure the connection details accordingly.
Start the services:

Start the Discovery Service (Spring Cloud Eureka) first.
Start the remaining microservices (Order Service, Inventory Service, Product Service, API Gateway) individually, ensuring they register with the Discovery Service.
Test the endpoints:

Use API testing tools like Postman to interact with the microservices through the API Gateway.
Refer to the API documentation for details on available endpoints and request/response formats.
