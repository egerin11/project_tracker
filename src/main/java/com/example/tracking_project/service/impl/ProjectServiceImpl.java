package com.example.tracking_project.service.impl;

import com.example.tracking_project.mapper.ProjectMapper;
import com.example.tracking_project.model.dto.request.ProjectRequest;
import com.example.tracking_project.model.dto.request.ProjectUserRequest;
import com.example.tracking_project.model.dto.response.ProjectResponse;
import com.example.tracking_project.model.dto.response.ProjectUserResponse;
import com.example.tracking_project.model.entity.Project;
import com.example.tracking_project.model.entity.User;
import com.example.tracking_project.rep.ProjectRepository;
import com.example.tracking_project.rep.UserRepository;
import com.example.tracking_project.service.ProjectService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository) {
        this.projectRepository = projectRepository;

        this.userRepository = userRepository;
    }

    @Override
    public ProjectResponse createProject(ProjectRequest projectRequest) {
        return ProjectMapper.toDto(projectRepository.save(ProjectMapper.toEntity(projectRequest)));
    }

    @Override
    public ProjectUserResponse addUserToProject(ProjectUserRequest projectUserRequest) {
        Long projectId = projectUserRequest.getProjectId();
        Long userId = projectUserRequest.getUserId();

        User user = userRepository.findById(userId).
                orElseThrow(() -> new EntityNotFoundException("User not found"));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new EntityNotFoundException("Project not found"));
        project.addUser(user);
        projectRepository.save(project);
        userRepository.save(user);
        return new ProjectUserResponse(userId, projectId);
    }
}
