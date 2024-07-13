package com.coderk.task_manager.repository;

import com.coderk.task_manager.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserData, Long> {

        Optional<UserData> findByUsername(String username);

}
