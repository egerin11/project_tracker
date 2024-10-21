package com.example.tracking_project.mapper;

import com.example.tracking_project.model.dto.request.ProjectRequest;
import com.example.tracking_project.model.dto.response.ProjectResponse;
import com.example.tracking_project.model.entity.Project;
import org.springframework.stereotype.Component;

@Component
public class ProjectMapper {
    private ProjectMapper() {
    }


    public static ProjectResponse toDto(Project project) {
        if (project == null) {
            return null;
        }
        ProjectResponse projectResponse = new ProjectResponse();
        projectResponse.setId(project.getId());
        projectResponse.setName(project.getName());
        projectResponse.setDescription(project.getDescription());
        return projectResponse;
    }

    public static Project toEntity(ProjectRequest projectRequest) {
        if (projectRequest == null) {
            return null;
        }
        Project project = new Project();
        project.setName(projectRequest.getName());
        project.setDescription(projectRequest.getDescription());
        return project;

    }
}
