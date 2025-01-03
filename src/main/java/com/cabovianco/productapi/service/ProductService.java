package com.cabovianco.productapi.service;

import com.cabovianco.productapi.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(Integer id);

    void addProduct(Product product);

    void updateProduct(Product product);

    void deleteProductById(Integer id);

}
