package com.catalog.Catalog.application.service;

import java.util.Optional;
import java.util.UUID;

import com.catalog.Catalog.application.dto.CategoryDTO;
import com.catalog.Catalog.domain.entity.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICategoryService {
    Page<Category> findAll(Pageable pageable);

    Optional<Category> findById(UUID id);

    Category create(CategoryDTO toAdd);

    Optional<Category> update(UUID id, CategoryDTO toAdd);

    void delete(UUID id);

}
