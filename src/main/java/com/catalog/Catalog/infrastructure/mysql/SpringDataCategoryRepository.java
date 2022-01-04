package com.catalog.Catalog.infrastructure.mysql;

import java.util.UUID;

import com.catalog.Catalog.domain.entity.Category;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpringDataCategoryRepository extends PagingAndSortingRepository<Category, UUID> {

}
