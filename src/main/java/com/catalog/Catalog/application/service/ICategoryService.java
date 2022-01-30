package com.catalog.Catalog.application.service;

import java.util.Optional;
import java.util.UUID;

import com.catalog.Catalog.application.dto.CategoryDTO;
import com.catalog.Catalog.domain.entity.Category;

public interface ICategoryService {
    Iterable<Category> findAll();

    Optional<Category> findById(UUID id);

    Category create(CategoryDTO toAdd);

    Optional<Category> update(UUID id, CategoryDTO toAdd);

    void delete(UUID id);

}
