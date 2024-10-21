package com.example.tracking_project.service;

import com.example.tracking_project.model.dto.request.ProjectRequest;
import com.example.tracking_project.model.dto.request.ProjectUserRequest;
import com.example.tracking_project.model.dto.response.ProjectResponse;
import com.example.tracking_project.model.dto.response.ProjectUserResponse;

public interface ProjectService {
    ProjectResponse createProject(ProjectRequest projectRequest);

    ProjectUserResponse addUserToProject(ProjectUserRequest projectUserRequest);
}
