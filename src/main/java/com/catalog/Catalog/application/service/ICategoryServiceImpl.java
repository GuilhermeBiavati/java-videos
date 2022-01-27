package com.catalog.Catalog.application.service;

import java.util.Optional;
import java.util.UUID;

import com.catalog.Catalog.application.dto.CategoryDTO;
import com.catalog.Catalog.domain.entity.Category;
import com.catalog.Catalog.domain.repository.ICategoryRepository;

import org.springframework.stereotype.Service;

@Service
public class ICategoryServiceImpl implements ICategoryService {

    ICategoryRepository categoryRepository;

    public ICategoryServiceImpl(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Iterable<Category> findAll() {
        return this.categoryRepository.findAllCategories();
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public Category create(CategoryDTO toAdd) {
        return this.categoryRepository.create(toAdd.toEntity());
    }

    @Override
    public Category update(UUID id, CategoryDTO toUpdate) {
        Category category = toUpdate.toEntity();
        category.setId(id);
        return this.categoryRepository.update(category);
    }

    @Override
    public void delete(UUID id) {
        this.categoryRepository.delete(id);
    }

}
