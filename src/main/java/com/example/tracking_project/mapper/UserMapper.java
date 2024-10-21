package com.example.tracking_project.mapper;

import com.example.tracking_project.model.dto.request.UserRequest;
import com.example.tracking_project.model.dto.response.UserResponse;
import com.example.tracking_project.model.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    private UserMapper() {
    }

    public static User toEntity(UserRequest userRequest) {
        if (userRequest == null) return null;
        User user = new User();
        user.setPassword(userRequest.getPassword());
        user.setEmail(userRequest.getEmail());
        user.setUsername(userRequest.getUsername());
        return user;
    }

    public static UserResponse toDto(User user) {
        if (user == null) return null;
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setUsername(user.getUsername());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }
}
