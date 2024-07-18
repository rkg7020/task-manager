package com.coderk.task_manager.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

   // @OneToMany(mappedBy = "category")
   // private List<Task> tasks;

}
