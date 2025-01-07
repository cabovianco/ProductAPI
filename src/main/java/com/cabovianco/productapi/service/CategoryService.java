package com.cabovianco.productapi.service;

import com.cabovianco.productapi.model.Category;
import com.cabovianco.productapi.model.Product;

import java.util.List;

public interface CategoryService {

    List<Category> getCategories();

    Category getCategoryById(Long id);

    List<Product> getProductsByCategoryId(Long id);

    Category addCategory(Category category);

    Category updateCategoryById(Long id, Category category);

    Category deleteCategoryById(Long id);

}
