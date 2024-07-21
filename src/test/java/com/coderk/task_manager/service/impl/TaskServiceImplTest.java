package com.coderk.task_manager.service.impl;

import com.coderk.task_manager.entity.Task;
import com.coderk.task_manager.repository.TaskRepository;
import com.coderk.task_manager.serviceImpl.TaskServiceimpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.assertj.core.api.Assertions.assertThat;


import java.time.LocalDate;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class TaskServiceImplTest {
    @InjectMocks
    private TaskServiceimpl taskService;

    @Mock
    private TaskRepository taskRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }
    @Test
    public void testCreateTask() {
        Task task = new Task();
        task.setTitle("Finish report");
        task.setDescription("Complete the final report");
        task.setDueDate(LocalDate.now());
        task.setStatus("PENDING");

        when(taskRepository.save(any(Task.class))).thenReturn(task);

        Task createdTask = taskService.createTask(task);
        assertThat(createdTask).isNotNull();
        assertThat(createdTask.getTitle()).isEqualTo("Finish report");
        verify(taskRepository, times(1)).save(any(Task.class));
    }
    @Test
    public void testGetTasksByDueDate() {
        Task task = new Task();
        task.setTitle("Finish report");
        task.setDescription("Complete the final report");
        task.setDueDate(LocalDate.now());
        task.setStatus("PENDING");

        when(taskRepository.findByDueDate(any(LocalDate.class))).thenReturn(List.of(task));

        List<Task> tasks = taskService.getTasksByDueDate(LocalDate.now());
        assertThat(tasks).isNotEmpty();
        assertThat(tasks.get(0).getTitle()).isEqualTo("Finish report");
    }
}
