package com.example.tracking_project.controller;

import com.example.tracking_project.model.dto.request.ProjectRequest;
import com.example.tracking_project.model.dto.request.ProjectUserRequest;
import com.example.tracking_project.model.dto.request.UserRequest;
import com.example.tracking_project.model.dto.response.ProjectResponse;
import com.example.tracking_project.model.dto.response.ProjectUserResponse;
import com.example.tracking_project.service.ProjectService;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ProjectResponse createProject(@RequestBody ProjectRequest projectRequest) {
        return projectService.createProject(projectRequest);
    }

    @PostMapping("/add-user")
    public ProjectUserResponse addUserToProject(@RequestBody ProjectUserRequest projectUserRequest) {
        return projectService.addUserToProject(projectUserRequest);
    }
    @GetMapping
    public List<ProjectResponse> getAllProjects() {
        return projectService.getProjects();
    }
    @GetMapping("/{projectId}")
    public ProjectResponse getProjectById(@PathVariable Long projectId) {
        return projectService.getProjectById(projectId);

    }
}
