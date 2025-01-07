package com.cabovianco.productapi.service;

import com.cabovianco.productapi.exception.CategoryNotFoundException;
import com.cabovianco.productapi.model.Category;
import com.cabovianco.productapi.model.Product;
import com.cabovianco.productapi.repository.CategoryRepository;
import com.cabovianco.productapi.repository.entity.CategoryEntity;
import com.cabovianco.productapi.util.EntityModelCategoryMapper;
import com.cabovianco.productapi.util.EntityModelProductMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.cabovianco.productapi.util.EntityModelCategoryMapper.toEntity;
import static com.cabovianco.productapi.util.EntityModelCategoryMapper.toModel;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getCategories() {
        return repository.findAllCategories()
                .stream()
                .map(EntityModelCategoryMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
    public Category getCategoryById(Long id) {
        return toModel(repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new));
    }

    @Override
    @SneakyThrows
    public List<Product> getProductsByCategoryId(Long id) {
        CategoryEntity category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        return category.getProducts()
                .stream()
                .map(EntityModelProductMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public Category addCategory(Category category) {
        return toModel(repository.save(toEntity(category)));
    }

    @Override
    @SneakyThrows
    public Category updateCategoryById(Long id, Category category) {
        CategoryEntity entity = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        CategoryEntity updatedEntity = toEntity(category);

        entity.setName(updatedEntity.getName());

        repository.save(entity);

        return toModel(entity);
    }

    @Override
    @SneakyThrows
    public Category deleteCategoryById(Long id) {
        CategoryEntity category = repository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        repository.deleteById(id);

        return toModel(category);
    }

}
