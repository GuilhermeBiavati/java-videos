package com.catalog.Catalog.infrastructure.mysql;

import java.util.Optional;
import java.util.UUID;

import com.catalog.Catalog.application.dto.CategoryDTO;
import com.catalog.Catalog.domain.entity.Category;
import com.catalog.Catalog.domain.repository.ICategoryRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlCategoryRepositoryImpl implements ICategoryRepository {

    private SpringDataCategoryRepository springDataCategoryRepository;

    public MySqlCategoryRepositoryImpl(SpringDataCategoryRepository springDataCategoryRepository) {
        this.springDataCategoryRepository = springDataCategoryRepository;
    }

    @Override
    public Page<Category> findAllCategories(Pageable pageable) {
        return this.springDataCategoryRepository.findAll(pageable);
    }

    @Override
    public Category create(Category toAdd) {
        return this.springDataCategoryRepository.save(toAdd);
    }

    @Override
    public Optional<Category> findById(UUID id) {
        return this.springDataCategoryRepository.findById(id);
    }

    @Override
    public Category update(Category toUpdate) {
        return this.springDataCategoryRepository.save(toUpdate);
    }

    @Override
    public void delete(UUID id) {
        this.springDataCategoryRepository.deleteById(id);
    }

    // @Override
    // public Optional<Category> findById() {
    // // TODO Auto-generated method stub
    // return null;
    // }

}
