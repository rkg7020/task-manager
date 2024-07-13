package com.coderk.task_manager.serviceImpl;

import com.coderk.task_manager.entity.UserData;
import com.coderk.task_manager.repository.UserRepository;
import com.coderk.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public UserData register(UserData user) {
        return userRepository.save(user);
    }

    @Override
    public UserData authenticate(String username, String password) {
        return null;
    }

    @Override
    public UserData updateUser(UserData user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
