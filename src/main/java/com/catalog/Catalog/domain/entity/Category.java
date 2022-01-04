package com.catalog.Catalog.domain.entity;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;

@Entity
@Table(name = "categories")
public class Category extends BaseEntity {

    @Column
    private String name;

    private Category() {
    }

    public Category(String name) {
        super.generateUUID();
        this.setName(name);
    }

    public Category(UUID id) {
        super.setId(id);
    }

    public Category(UUID id, String name) {
        super.setId(id);
        this.setName(name);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null)
            throw new IllegalArgumentException("type is marked non-null but is null");
        if (name.length() == 0)
            throw new IllegalArgumentException("type is marked not-blank but is not-blank");
        this.name = name;
    }
}
