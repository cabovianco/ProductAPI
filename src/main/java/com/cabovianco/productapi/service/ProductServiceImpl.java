package com.cabovianco.productapi.service;

import com.cabovianco.productapi.Database;
import com.cabovianco.productapi.model.Product;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final Database database = new Database();

    @Override
    public List<Product> getProducts() {
        return database.getProducts();
    }

    @Override
    public Product getProductById(Integer id) {
        try {
            return database.getProductById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addProduct(Product product) {
        database.addProduct(product);
    }

    @Override
    public void updateProduct(Product product) {
        try {
            database.updateProduct(product);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteProductById(Integer id) {
        try {
            database.deleteProduct(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
