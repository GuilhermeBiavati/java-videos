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
public class BaseEntityTests {

    // @Test
    // public void createBaseEntity() {
    // final BaseEntity entity = new BaseEntity();
    // assertNotNull(entity);
    // assertTrue(entity.isValidUUID(entity.getId().toString()));
    // }

    // @Test
    // public void throwIllegalArgumentExceptionWhenIdIsNull() {
    // assertThrows(IllegalArgumentException.class, () -> new BaseEntity((UUID)
    // null));
    // }

    // @Test
    // public void throwIllegalArgumentExceptionWhenIdIsValid() {
    // assertThrows(IllegalArgumentException.class, () -> new
    // BaseEntity(UUID.fromString("dsf")));
    // }

}
