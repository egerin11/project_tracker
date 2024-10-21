package com.example.tracking_project.model.dto.request;


import com.example.tracking_project.model.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskRequest {
    private String title;
    private String description;
    private TaskStatus status;
    private Long projectId;
    private Long assignedUserId;
}
