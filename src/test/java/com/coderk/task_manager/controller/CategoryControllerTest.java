package com.coderk.task_manager.controller;

import com.coderk.task_manager.entity.Category;
import com.coderk.task_manager.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@SpringBootTest

   @AutoConfigureMockMvc
    public class CategoryControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @Autowired
        private CategoryService categoryService;

        @Test
        public void testCreateCategory() throws Exception {
            mockMvc.perform(post("/api/categories")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"name\": \"Work\"}"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Work"));
        }

        @Test
        public void testGetAllCategories() throws Exception {
            Category category = new Category();
            category.setName("Work");
            categoryService.createCategory(category);

            mockMvc.perform(get("/api/categories"))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.jsonPath("$[0].name").value("Work"));
        }

    }
