package com.catalog.Catalog.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CategoryTests {

    @Test
    public void createCategory() {
        final Category entity = new Category("asfasdfsad");
        assertNotNull(entity);
        assertEquals(entity.getName(), "asfasdfsad");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Category((String) null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Category(""));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Category((UUID) null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenIdIsValid() {
        assertThrows(IllegalArgumentException.class, () -> new Category(UUID.fromString("dsf")));
    }

}
