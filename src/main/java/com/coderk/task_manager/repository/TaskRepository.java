package com.coderk.task_manager.repository;

import com.coderk.task_manager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository <Task,Long>{
    List<Task> findByCategoryId(Long categoryId);
    List<Task> findByDueDate(LocalDate dueDate);

}
