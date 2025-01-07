package com.cabovianco.productapi.repository;

import com.cabovianco.productapi.repository.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    @Query(value = "SELECT * FROM categories ORDER BY id", nativeQuery = true)
    List<CategoryEntity> findAllCategories();

}
