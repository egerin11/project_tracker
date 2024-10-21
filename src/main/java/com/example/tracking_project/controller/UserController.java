package com.example.tracking_project.controller;

import com.example.tracking_project.model.dto.request.UserRequest;
import com.example.tracking_project.model.dto.response.UserResponse;
import com.example.tracking_project.model.dto.response.UserTaskResponse;
import com.example.tracking_project.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse addUser(@RequestBody UserRequest user) {
        return userService.addUser(user);
    }

    @PostMapping("/user/{userId}/task/{taskId}")
    public UserTaskResponse addTaskToUser(@PathVariable Long userId, @PathVariable Long taskId) {
        return userService.addTaskToUser(userId, taskId);
    }

    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getUsers();
    }
}
