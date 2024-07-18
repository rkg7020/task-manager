package com.coderk.task_manager.service;


import com.coderk.task_manager.entity.Task;

import java.time.LocalDate;
import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Long id);
    Task updateTask(Task task);
    void deleteTask(Long id);
    List<Task> getAllTasks();
    List<Task> getTasksByCategory(Long categoryId);
    List<Task> getTasksByDueDate(LocalDate dueDate);
}
