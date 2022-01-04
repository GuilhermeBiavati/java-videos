package com.catalog.Catalog.domain.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class VideoTests {

    @Test
    public void throwIllegalArgumentExceptionWhenTitleIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Video(null, "", 0, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenNameIsBlank() {
        assertThrows(IllegalArgumentException.class, () -> new Video("", "", 0, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenYearLauchedIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Video("Title", null, null, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenYearLauchedIsGreaterThanCurrentYear() {
        assertThrows(IllegalArgumentException.class,
                () -> new Video("Title", "dasfs", Calendar.getInstance().get(Calendar.YEAR) + 1, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenIdIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Video((UUID) null, "Title", "null", 2000, false));
    }

    @Test
    public void throwIllegalArgumentExceptionWhenIdIsInvalid() {
        assertThrows(IllegalArgumentException.class,
                () -> new Video((UUID) UUID.fromString("sdfa"), "Title", "null", 2000, false));
    }

    @Test
    public void createVideoWithTitleAndYearLauchedTest() {
        final Video entity = new Video("asfasdfsad", "my description", 2012, false);
        assertNotNull(entity);
        assertEquals(entity.getTitle(), "asfasdfsad");
        assertEquals(entity.getYearLaunched(), 2012);
        assertEquals(entity.getDescription(), "my description");
        assertEquals(entity.getOpened(), false);
        assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void createVideoWithTitleAndYearLauchedAndRatingAndDurationTest() {
        final Video entity = new Video("asfasdfsad", "my description", 2012, false, "Rating 10", (float) 10.5);
        assertNotNull(entity);
        assertEquals(entity.getTitle(), "asfasdfsad");
        assertEquals(entity.getYearLaunched(), 2012);
        assertEquals(entity.getDescription(), "my description");
        assertEquals(entity.getOpened(), false);
        assertEquals(entity.getRating(), "Rating 10");
        assertEquals(entity.getDuration(), (float) 10.5);
        assertTrue(entity.isValidUUID(entity.getId().toString()));
    }

    @Test
    public void createVideoWithoutFilesTest() {

        final Category category = new Category("Category");
        final Category category2 = new Category("Category 2");
        final Genre genre = new Genre("Ação");
        final Genre genre2 = new Genre("Aventura");
        final CastMember castMember = new CastMember("Guilherme");
        final CastMember castMember2 = new CastMember("José");

        List<Category> categories = new ArrayList<Category>();
        categories.add(category);
        categories.add(category2);

        List<Genre> genres = new ArrayList<Genre>();
        genres.add(genre);
        genres.add(genre2);

        List<CastMember> castMembers = new ArrayList<CastMember>();
        castMembers.add(castMember);
        castMembers.add(castMember2);

        assertNotNull(castMembers);
        assertNotNull(genres);
        assertNotNull(categories);
        final Video entity = new Video("asfasdfsad", "my description", 2012, (float) 10.5, categories, genres,
                castMembers);

        assertNotNull(entity);
        assertEquals(entity.getTitle(), "asfasdfsad");
        assertEquals(entity.getYearLaunched(), 2012);
        assertEquals(entity.getDescription(), "my description");
        assertEquals(entity.getDuration(), (float) 10.5);
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertNotNull(entity.getCategories());
        assertNotNull(entity.getCastMembers());
        assertNotNull(entity.getGenres());
    }

    @Test
    public void createVideoWithoutFileWithCategoriesTest() {

        final Category category = new Category("Category");
        final Category category2 = new Category("Category 2");

        List<Category> categories = new ArrayList<Category>();
        categories.add(category);
        categories.add(category2);

        final Video entity = new Video("asfasdfsad", "my description", 2012, (float) 10.5);

        entity.setCategories(categories);

        assertNotNull(categories);
        assertNotNull(entity);
        assertEquals(entity.getTitle(), "asfasdfsad");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertEquals(category.getName(), "Category");
        assertEquals(category2.getName(), "Category 2");
        assertTrue(category.isValidUUID(category.getId().toString()));
        assertTrue(category2.isValidUUID(category2.getId().toString()));
        assertEquals(2, entity.getCategories().size());

    }

    @Test
    public void createVideoWithoutFileWithAddCategoriesTest() {

        final Category category = new Category("Category");
        final Category category2 = new Category("Category 2");

        assertNotNull(category);
        assertNotNull(category2);

        final Video entity = new Video("asfasdfsad", "my description", 2012, (float) 10.5);

        entity.addCategory(category);
        entity.addCategory(category2);

        assertNotNull(entity);
        assertEquals(entity.getTitle(), "asfasdfsad");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertEquals(category.getName(), "Category");
        assertEquals(category2.getName(), "Category 2");
        assertTrue(category.isValidUUID(category.getId().toString()));
        assertTrue(category2.isValidUUID(category2.getId().toString()));
        assertEquals(2, entity.getCategories().size());

    }

    @Test
    public void createVideoWithoutFileWithAddGenresTest() {

        final Genre genre = new Genre("Genre");
        final Genre genre2 = new Genre("Genre 2");

        assertNotNull(genre);
        assertNotNull(genre2);

        final Video entity = new Video("asfasdfsad", "my description", 2012, (float) 10.5);

        entity.addGenre(genre);
        entity.addGenre(genre2);

        assertNotNull(entity);
        assertEquals(entity.getTitle(), "asfasdfsad");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertEquals(genre.getName(), "Genre");
        assertEquals(genre2.getName(), "Genre 2");
        assertTrue(genre.isValidUUID(genre.getId().toString()));
        assertTrue(genre2.isValidUUID(genre2.getId().toString()));
        assertEquals(2, entity.getGenres().size());

    }

    @Test
    public void createVideoWithoutFileWithAddCastMembersTest() {

        final CastMember castMember = new CastMember("Guilherme");
        final CastMember castMember2 = new CastMember("José");

        assertNotNull(castMember);
        assertNotNull(castMember2);

        final Video entity = new Video("asfasdfsad", "my description", 2012, (float) 10.5);

        entity.addCastMember(castMember);
        entity.addCastMember(castMember2);

        assertNotNull(entity);
        assertEquals(entity.getTitle(), "asfasdfsad");
        assertTrue(entity.isValidUUID(entity.getId().toString()));
        assertEquals(castMember.getName(), "Guilherme");
        assertEquals(castMember2.getName(), "José");
        assertTrue(castMember.isValidUUID(castMember.getId().toString()));
        assertTrue(castMember2.isValidUUID(castMember2.getId().toString()));
        assertEquals(2, entity.getCastMembers().size());

    }

    // @Test
    // public void createVideoWithNameAndCategories() {

    // final Category category = new Category("asfasdfsad");
    // final Category category2 = new Category("asfasdfsad");

    // List<Category> categories = new ArrayList<Category>();
    // categories.add(category);
    // categories.add(category2);

    // final Video entity = new Video("asfasdfsad", categories);

    // assertNotNull(categories);
    // assertNotNull(entity);
    // assertNotNull(entity.getCategories());
    // assertEquals(entity.getName(), "asfasdfsad");
    // assertEquals(entity.getCategories().size(), 2);
    // assertTrue(entity.isValidUUID(entity.getId().toString()));
    // }

    // @Test
    // public void addCategoryToVideoTest() {
    // final Video entity = new Video("asfasdfsad");

    // assertNotNull(entity);
    // assertNotNull(entity.getCategories());

    // final Category category = new Category("asfasdfsad");
    // final Category category2 = new Category("asfasdfsad");

    // entity.addCategory(category);
    // entity.addCategory(category2);

    // assertEquals(2, entity.getCategories().size());
    // }

    // @Test
    // public void removeCategoryFromVideoTest() {
    // final Video entity = new Video("asfasdfsad");

    // assertNotNull(entity);
    // assertNotNull(entity.getCategories());

    // final Category category = new Category("asfasdfsad");
    // final Category category2 = new Category("asfasdfsad");

    // entity.addCategory(category);
    // entity.addCategory(category2);

    // assertNotNull(entity.getCategories());

    // assertEquals(2, entity.getCategories().size());
    // entity.removeCategory(category);
    // assertEquals(1, entity.getCategories().size());
    // entity.removeCategory(category2);
    // assertEquals(0, entity.getCategories().size());
    // }

}
