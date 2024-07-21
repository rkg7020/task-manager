package com.coderk.task_manager.repository;

import com.coderk.task_manager.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void testCreateCategory() {
        Category category = new Category();
        category.setName("Work");

        Category savedCategory = categoryRepository.save(category);
        assertThat(savedCategory).isNotNull();
        assertThat(savedCategory.getId()).isNotNull();
    }
    @Test
    public void testFindAllCategories() {
        Category category1 = new Category();
        category1.setName("Work");
        categoryRepository.save(category1);

        Category category2 = new Category();
        category2.setName("Personal");
        categoryRepository.save(category2);

        List<Category> categories = categoryRepository.findAll();
        assertEquals(2,categories.size());
    }
}
