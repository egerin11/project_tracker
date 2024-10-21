package com.example.tracking_project.controller;

import com.example.tracking_project.model.dto.request.TaskRequest;
import com.example.tracking_project.model.dto.response.TaskResponse;
import com.example.tracking_project.service.impl.TaskServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskServiceImpl taskServiceImpl;

    public TaskController(TaskServiceImpl taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }

    @PostMapping
    public TaskResponse addTask(@RequestBody TaskRequest task) {
        return taskServiceImpl.addTask(task);
    }

    @GetMapping("/{userId}")
    public List<TaskResponse> getAllTasks(@PathVariable Long userId) {
        return taskServiceImpl.getTasksByUserId(userId);
    }
}
