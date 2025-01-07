package com.cabovianco.productapi.util;

import com.cabovianco.productapi.model.Category;
import com.cabovianco.productapi.repository.entity.CategoryEntity;

public class EntityModelCategoryMapper {

    public static Category toModel(CategoryEntity category) {
        Category model = new Category();
        model.setId(category.getId());
        model.setName(category.getName());

        return model;
    }

    public static CategoryEntity toEntity(Category category) {
        CategoryEntity entity = new CategoryEntity();
        entity.setId(category.getId());
        entity.setName(category.getName());

        return entity;
    }

}
