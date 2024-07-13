package com.coderk.task_manager.controller;



import com.coderk.task_manager.entity.UserData;
import com.coderk.task_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("api/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("register")
    public ResponseEntity<UserData> registerUser(@RequestBody UserData user) {
        UserData registeredUser = userService.register(user);
        return ResponseEntity.ok(registeredUser);

    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        UserData authenticatedUser = userService.authenticate(credentials.get("username"), credentials.get("password"));
        return ResponseEntity.ok(authenticatedUser);
    }
    @PutMapping("/update")
    public ResponseEntity<UserData> update(@RequestBody UserData userData) {
        UserData updatedUserData = userService.updateUser(userData);
        return ResponseEntity.ok(updatedUserData);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

}
