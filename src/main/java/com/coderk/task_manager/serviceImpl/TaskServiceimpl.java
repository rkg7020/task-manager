package com.coderk.task_manager.serviceImpl;

import com.coderk.task_manager.entity.Task;
import com.coderk.task_manager.repository.TaskRepository;
import com.coderk.task_manager.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TaskServiceimpl  implements TaskService {
    @Autowired
    TaskRepository taskRepository;
    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    @Override
    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);

    }

    @Override
    public List<Task> getAllTasks() {
        return  taskRepository.findAll();

    }

    @Override
    public List<Task> getTasksByCategory(Long categoryId) {
        return taskRepository.findByCategoryId(categoryId);
    }

    @Override
    public List<Task> getTasksByDueDate(LocalDate dueDate) {
        return taskRepository.findByDueDate(dueDate);
    }
}
