package com.cabovianco.productapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * EndPoints:
 * GET /products: List all products.
 * GET /products/{id}: Get a product by ID.
 * POST /products: Create a new product.
 * PUT /products/{id}: Update a product.
 * DELETE /products/{id}: Delete a product by ID.
 */

@SpringBootApplication
public class ProductApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApiApplication.class, args);
    }

}
