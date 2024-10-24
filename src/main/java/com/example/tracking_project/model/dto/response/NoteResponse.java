package com.example.tracking_project.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {
    private Long id;
    private String content;
    private LocalDateTime createdAt;
    private Long taskId;
    private Long authorId;
}
