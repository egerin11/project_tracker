package com.example.tracking_project.service.impl;

import com.example.tracking_project.mapper.TaskMapper;
import com.example.tracking_project.model.dto.request.TaskRequest;
import com.example.tracking_project.model.dto.response.TaskResponse;
import com.example.tracking_project.model.entity.Task;
import com.example.tracking_project.rep.TaskRepository;
import com.example.tracking_project.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    @Override
    public TaskResponse addTask(TaskRequest task) {
        return TaskMapper.toDto(taskRepository.save(TaskMapper.toEntity(task)));
    }
    @Override
    public List<TaskResponse> getTasksByUserId(Long userId) {
        List<Task> tasks = taskRepository.findTasksByUserId(userId);
        return tasks.stream().map(TaskMapper::toDto).peek(taskResponse -> taskResponse.setAssignedUserId(userId)).toList();
    }
}
