package com.cabovianco.productapi.repository;

import com.cabovianco.productapi.repository.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Query(value = "SELECT * FROM products ORDER BY id", nativeQuery = true)
    List<ProductEntity> findAllProducts();

}
