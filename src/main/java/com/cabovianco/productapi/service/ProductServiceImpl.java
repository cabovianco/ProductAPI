package com.cabovianco.productapi.service;

import com.cabovianco.productapi.exception.CategoryNotFoundException;
import com.cabovianco.productapi.exception.ProductNotFoundException;
import com.cabovianco.productapi.model.Category;
import com.cabovianco.productapi.model.Product;
import com.cabovianco.productapi.repository.CategoryRepository;
import com.cabovianco.productapi.repository.ProductRepository;
import com.cabovianco.productapi.repository.entity.CategoryEntity;
import com.cabovianco.productapi.repository.entity.ProductEntity;
import com.cabovianco.productapi.util.EntityModelCategoryMapper;
import com.cabovianco.productapi.util.EntityModelProductMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.cabovianco.productapi.util.EntityModelProductMapper.toEntity;
import static com.cabovianco.productapi.util.EntityModelProductMapper.toModel;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAllProducts()
                .stream()
                .map(EntityModelProductMapper::toModel)
                .collect(Collectors.toList());
    }

    @Override
    @SneakyThrows
    public Product getProductById(Long id) {
        return toModel(productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new));
    }

    @Override
    public Product addProduct(Product product) {
        return toModel(productRepository.save(toEntity(product)));
    }

    @Override
    @SneakyThrows
    public Category addCategoryToProduct(Long id, Long categoryId) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        CategoryEntity category = categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFoundException::new);

        product.setCategory(category);
        productRepository.save(product);

        return EntityModelCategoryMapper.toModel(category);
    }

    @Override
    @SneakyThrows
    public Product updateProductById(Long id, Product product) {
        ProductEntity entity = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        ProductEntity updatedEntity = toEntity(product);

        entity.setName(updatedEntity.getName());
        entity.setPrice(updatedEntity.getPrice());
        entity.setCategory(updatedEntity.getCategory());

        productRepository.save(entity);

        return toModel(entity);
    }

    @Override
    @SneakyThrows
    public Product deleteProductById(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        productRepository.deleteById(id);

        return toModel(product);
    }

    @Override
    @SneakyThrows
    public Category getCategoryByProductId(Long id) {
        ProductEntity product = productRepository.findById(id)
                .orElseThrow(ProductNotFoundException::new);

        CategoryEntity category = product.getCategory();
        if (category == null)
            throw new CategoryNotFoundException();

        return EntityModelCategoryMapper.toModel(category);
    }

}
