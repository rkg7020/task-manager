package com.coderk.task_manager.service;


import com.coderk.task_manager.entity.UserData;

public interface UserService {
        UserData register(UserData userData);
        UserData authenticate(String username, String password);
        UserData updateUser(UserData userData);
        void deleteUser(Long id);
    }


