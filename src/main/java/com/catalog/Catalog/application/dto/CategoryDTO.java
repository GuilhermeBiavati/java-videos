package com.catalog.Catalog.application.dto;

import java.io.Serializable;
import java.util.UUID;

import com.catalog.Catalog.domain.entity.Category;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDTO implements Serializable {

    private static final long serialVersionUID = 1L;
    private String name;

    public Category toEntity() {
        Mapper mapper = DozerBeanMapperBuilder.buildDefault();
        Category entity = mapper.map(this, Category.class);

        return entity;
    }
}
