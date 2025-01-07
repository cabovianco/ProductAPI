package com.cabovianco.productapi.controller;

import com.cabovianco.productapi.model.Category;
import com.cabovianco.productapi.model.Product;
import com.cabovianco.productapi.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private final ProductService service;

    @Autowired
    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/products")
    ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getProducts());
    }

    @GetMapping("/products/{id}")
    ResponseEntity<Product> getProductById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getProductById(id));
    }

    @GetMapping("/products/{id}/category")
    ResponseEntity<Category> getCategoryByProductId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getCategoryByProductId(id));
    }

    @PostMapping("/products")
    ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addProduct(product));
    }

    @PostMapping("/products/{id}")
    ResponseEntity<Category> addCategoryToProduct(@PathVariable Long id, @RequestParam Long categoryId) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addCategoryToProduct(id, categoryId));
    }

    @PutMapping("/products/{id}")
    ResponseEntity<Product> updateProductById(@PathVariable Long id, @Valid @RequestBody Product product) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateProductById(id, product));
    }

    @DeleteMapping("/products/{id}")
    ResponseEntity<Product> deleteProductById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.deleteProductById(id));
    }

}
