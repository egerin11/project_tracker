package com.example.tracking_project.mapper;


import com.example.tracking_project.model.dto.request.TaskRequest;
import com.example.tracking_project.model.dto.response.TaskResponse;
import com.example.tracking_project.model.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    private TaskMapper() {
    }

    public static TaskResponse toDto(Task task) {
        if (task == null) return null;
        TaskResponse taskResponse = new TaskResponse();
        taskResponse.setId(task.getId());
        taskResponse.setTitle(task.getTitle());
        taskResponse.setDescription(task.getDescription());
        taskResponse.setStatus(task.getStatus());
        taskResponse.setAssignedUserId(taskResponse.getAssignedUserId());
        taskResponse.setProjectId(taskResponse.getProjectId());
        return taskResponse;
    }

    public static Task toEntity(TaskRequest taskRequest) {
        if (taskRequest == null) return null;
        Task task = new Task();
        task.setStatus(taskRequest.getStatus());
        task.setTitle(taskRequest.getTitle());
        task.setDescription(taskRequest.getDescription());
        return task;

    }
}
