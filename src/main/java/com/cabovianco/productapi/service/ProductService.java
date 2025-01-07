package com.cabovianco.productapi.service;

import com.cabovianco.productapi.model.Category;
import com.cabovianco.productapi.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(Long id);

    Category getCategoryByProductId(Long id);

    Product addProduct(Product product);

    Category addCategoryToProduct(Long id, Long categoryId);

    Product updateProductById(Long id, Product product);

    Product deleteProductById(Long id);

}
