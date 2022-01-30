package com.catalog.Catalog.application.web;

import java.util.UUID;

import com.catalog.Catalog.application.dto.CategoryDTO;
import com.catalog.Catalog.application.service.ICategoryService;
import com.catalog.Catalog.domain.entity.Category;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private ICategoryService categoryService;

    public CategoryController(ICategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public ResponseEntity<Page<Category>> findAll(Pageable pageable) {
        try {
            return ResponseEntity.ok().body(this.categoryService.findAll(pageable));
        } catch (Exception e) {
        }
        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable UUID id) {
        try {
            return this.categoryService.findById(id).map(record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {

        }

        return null;
    }

    @PostMapping
    public ResponseEntity<Category> create(@RequestBody CategoryDTO toAdd) {
        try {
            Category category = this.categoryService.create(toAdd);
            return ResponseEntity.status(HttpStatus.CREATED).body(category);
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable UUID id, @RequestBody CategoryDTO toUpdate) {
        try {
            return this.categoryService.update(id, toUpdate).map(record -> ResponseEntity.ok().body(record))
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable UUID id) {
        try {
            return categoryService.findById(id).map(record -> {
                this.categoryService.delete(id);
                return ResponseEntity.noContent().build();
            }).orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            // TODO: handle exception
        }

        return null;
    }
}
