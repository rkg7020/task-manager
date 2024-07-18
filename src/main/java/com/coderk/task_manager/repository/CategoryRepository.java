package com.coderk.task_manager.repository;

import com.coderk.task_manager.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


  //  Category saveCategoryById(Long id);
}
