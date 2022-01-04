package com.catalog.Catalog.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class GenreTests {

    @Test
    public void createGenreWithName() {
        final Genre entity = new Genre("asfasdfsad");
        assertNotNull(entity);
        assertEquals(entity.getName(), "asfasdfsad");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void createGenreWithNameAndCategories() {

        final Category category = new Category("asfasdfsad");
        final Category category2 = new Category("asfasdfsad");

        List<Category> categories = new ArrayList<Category>();
        categories.add(category);
        categories.add(category2);

        final Genre entity = new Genre("asfasdfsad", categories);

        assertNotNull(categories);
        assertNotNull(entity);
        assertNotNull(entity.getCategories());
        assertEquals(entity.getName(), "asfasdfsad");
        assertEquals(entity.getCategories().size(), 2);
        assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Genre((String) null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Genre(""));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Genre((UUID) null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenIdIsValid() {
        assertThrows(IllegalArgumentException.class, () -> new Genre(UUID.fromString("dsf")));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNullAndCategoriesIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Genre((String) null, null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlankAndCategoriesIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Genre("", null));
    }

    @Test
    public void addCategoryToGenreTest() {
        final Genre entity = new Genre("asfasdfsad");

        assertNotNull(entity);
        assertNotNull(entity.getCategories());

        final Category category = new Category("asfasdfsad");
        final Category category2 = new Category("asfasdfsad");

        entity.addCategory(category);
        entity.addCategory(category2);

        assertEquals(2, entity.getCategories().size());
    }

    @Test
    public void removeCategoryFromGenreTest() {
        final Genre entity = new Genre("asfasdfsad");

        assertNotNull(entity);
        assertNotNull(entity.getCategories());

        final Category category = new Category("asfasdfsad");
        final Category category2 = new Category("asfasdfsad");

        entity.addCategory(category);
        entity.addCategory(category2);

        assertNotNull(entity.getCategories());

        assertEquals(2, entity.getCategories().size());
        entity.removeCategory(category);
        assertEquals(1, entity.getCategories().size());
        entity.removeCategory(category2);
        assertEquals(0, entity.getCategories().size());
    }

}
