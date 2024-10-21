package com.example.tracking_project.service.impl;

import com.example.tracking_project.mapper.UserMapper;
import com.example.tracking_project.model.dto.request.UserRequest;
import com.example.tracking_project.model.dto.response.UserResponse;
import com.example.tracking_project.model.dto.response.UserTaskResponse;
import com.example.tracking_project.model.entity.Task;
import com.example.tracking_project.model.entity.User;
import com.example.tracking_project.rep.TaskRepository;
import com.example.tracking_project.rep.UserRepository;
import com.example.tracking_project.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final TaskRepository taskRepository;

    public UserServiceImpl(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public UserResponse addUser(UserRequest user) {
        return UserMapper.toDto(userRepository.save(UserMapper.toEntity(user)));
    }

    @Override
    public UserTaskResponse addTaskToUser(Long userId, Long taskId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        user.getTasks().add(task);
        task.getAssignedUsers().add(user);
        taskRepository.save(task);
        userRepository.save(user);
        return new UserTaskResponse(taskId, userId);
    }
    @Override
    public List<UserResponse> getUsers() {
        return userRepository.findAll().stream().map(UserMapper::toDto).toList();
    }
}
