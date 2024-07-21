package com.coderk.task_manager.controller;

import com.coderk.task_manager.entity.Category;
import com.coderk.task_manager.entity.Task;
import com.coderk.task_manager.service.CategoryService;
import com.coderk.task_manager.service.TaskService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;




@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TaskService taskService;

    @Test
    public void testCreateTask() throws Exception {
        mockMvc.perform(post("/api/tasks")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"title\": \"Finish report\", \"description\": \"Complete the final report\", \"dueDate\": \"2024-07-10\", \"status\": \"PENDING\", \"category\": {\"id\": 1}}"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.title").value("Finish report"));
    }

    @Test
    public void testGetTasksByDueDate() throws Exception {
        Task task = new Task();
        task.setTitle("Finish report");
        task.setDescription("Complete the final report");
        task.setDueDate(LocalDate.now());
        task.setStatus("PENDING");
        taskService.createTask(task);

        mockMvc.perform(get("/api/tasks/duedate/" + LocalDate.now().toString()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].title").value("Finish report"));
    }
}
