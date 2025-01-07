package com.cabovianco.productapi.controller;

import com.cabovianco.productapi.model.Category;
import com.cabovianco.productapi.model.Product;
import com.cabovianco.productapi.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {

    private final CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping("/categories")
    ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getCategories());
    }

    @GetMapping("/categories/{id}")
    ResponseEntity<Category> getCategoryById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getCategoryById(id));
    }

    @GetMapping("/categories/{id}/products")
    ResponseEntity<List<Product>> getProductsByCategoryId(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.getProductsByCategoryId(id));
    }

    @PostMapping("/categories")
    ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.addCategory(category));
    }

    @PutMapping("/categories/{id}")
    ResponseEntity<Category> updateCategoryById(@PathVariable Long id, @RequestBody @Valid Category category) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.updateCategoryById(id, category));
    }

    @DeleteMapping("/categories/{id}")
    ResponseEntity<Category> deleteCategoryById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(service.deleteCategoryById(id));
    }

}
