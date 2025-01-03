package com.cabovianco.productapi;

import com.cabovianco.productapi.model.Product;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private final List<Product> database = new ArrayList<>();

    public List<Product> getProducts() {
        return database;
    }

    public Product getProductById(Integer id) throws Exception {
        if (id < 0 || id > database.size())
            throw new Exception("Product not found");

        return database.get(id);
    }

    public void addProduct(Product product) {
        database.add(product.getId(), product);
    }

    public void updateProduct(Product product) throws Exception {
        Integer id = product.getId();
        if (id < 0 || id > database.size())
            throw new Exception("Product not found");

        database.remove((int) id);
        database.add(id, product);
    }

    public void deleteProduct(Integer id) throws Exception {
        if (id < 0 || id > database.size())
            throw new Exception("Product not found");

        database.remove((int) id);
    }

}
