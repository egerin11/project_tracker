package com.example.tracking_project.service;

import com.example.tracking_project.model.dto.request.UserRequest;
import com.example.tracking_project.model.dto.response.UserResponse;
import com.example.tracking_project.model.dto.response.UserTaskResponse;

import java.util.List;

public interface UserService {
    UserResponse addUser(UserRequest user);

    UserTaskResponse addTaskToUser(Long userId, Long taskId);

    List<UserResponse> getUsers();
}
