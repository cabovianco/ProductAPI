package com.cabovianco.productapi.controller;

import com.cabovianco.productapi.model.Product;
import com.cabovianco.productapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    List<Product> getProducts() {
        return service.getProducts();
    }

    @GetMapping("/products/{id}")
    String getProductById(@PathVariable Integer id) {
        try {
            Product product = service.getProductById(id);
            return "{\n" +
                    product.getId() + ",\n" +
                    product.getName() + ",\n" +
                    product.getCategory() + ",\n" +
                    product.getPrice() +
                    "\n}";
        } catch (Exception e) {
            return "Product not found";
        }
    }

    @PostMapping("/products")
    String addProduct(@RequestBody Product product) {
        service.addProduct(product);
        return "Product added";
    }

    @PutMapping("/products/{id}")
    String updateProduct(@RequestBody Product product) {
        try {
            service.updateProduct(product);
            return "Product updated";
        } catch (Exception e) {
            return "Product not found";
        }
    }

    @DeleteMapping("/products/{id}")
    String deleteProduct(@PathVariable Integer id) {
        try {
            service.deleteProductById(id);
            return "Product deleted";
        } catch (Exception e) {
            return "Product not found";
        }
    }

}
