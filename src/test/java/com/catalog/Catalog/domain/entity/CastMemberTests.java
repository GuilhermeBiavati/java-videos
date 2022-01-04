package com.catalog.Catalog.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CastMemberTests {

    @Test
    public void createCastMemberWithName() {
        final CastMember entity = new CastMember("Cast Member");
        assertNotNull(entity);
        assertEquals(entity.getName(), "Cast Member");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertNull(entity.getType());
    }

    @Test
    @EnumSource(value = CastMemberType.class)
    public void createCastMemberWithNameAndType() {
        final CastMember entity = new CastMember("asfasdfsad", CastMemberType.TYPE1);
        assertNotNull(entity);
        assertEquals(entity.getName(), "asfasdfsad");
        assertEquals(entity.getType(), CastMemberType.TYPE1);
        assertTrue(CastMemberType.valueOf(entity.getType()));
        assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CastMember((String) null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new CastMember(""));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsNullAndTypeIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CastMember((String) null, null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlankAndTypeIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CastMember("", null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenTypeIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new CastMember("exemplo", null));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenTypeIsNotValid() throws IllegalArgumentException {

        assertThrows(IllegalArgumentException.class, () -> {
            CastMember entity = mock(CastMember.class);
            doThrow(IllegalArgumentException.class).when(entity).setType(CastMemberType.TYPE2);

            entity.setType(CastMemberType.TYPE2);
        });
    }

}
