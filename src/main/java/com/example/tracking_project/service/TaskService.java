package com.example.tracking_project.service;

import com.example.tracking_project.model.dto.request.TaskRequest;
import com.example.tracking_project.model.dto.response.TaskResponse;

import java.util.List;

public interface TaskService {

    List<TaskResponse> getTasksByUserId(Long userId);

    TaskResponse addTask(TaskRequest taskRequest);
}
