package com.cabovianco.productapi.util;

import com.cabovianco.productapi.model.Product;
import com.cabovianco.productapi.repository.entity.ProductEntity;

public class EntityModelProductMapper {

    public static Product toModel(ProductEntity product) {
        Product model = new Product();
        model.setId(product.getId());
        model.setName(product.getName());
        model.setPrice(product.getPrice());

        return model;
    }

    public static ProductEntity toEntity(Product product) {
        ProductEntity entity = new ProductEntity();
        entity.setId(product.getId());
        entity.setName(product.getName());
        entity.setPrice(product.getPrice());

        return entity;
    }

}
