package com.catalog.Catalog.domain.repository;

import java.util.Optional;
import java.util.UUID;

import com.catalog.Catalog.application.dto.CategoryDTO;
import com.catalog.Catalog.domain.entity.Category;

public interface ICategoryRepository {
    Iterable<Category> findAllCategories();

    Optional<Category> findById(UUID id);

    Category create(Category toAdd);

    Category update(Category toUpdate);

    void delete(UUID id);
}
