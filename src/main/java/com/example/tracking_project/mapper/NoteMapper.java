package com.example.tracking_project.mapper;

import com.example.tracking_project.model.dto.request.NoteRequest;
import com.example.tracking_project.model.dto.response.NoteResponse;
import com.example.tracking_project.model.entity.Note;
import org.springframework.stereotype.Component;

@Component
public class NoteMapper {
    private NoteMapper() {
    }

    public static NoteResponse toDto(Note note) {
        if (note == null) return null;
        NoteResponse noteResponse = new NoteResponse();
        noteResponse.setId(note.getId());
        noteResponse.setAuthorId(note.getAuthor().getId());
        noteResponse.setTaskId(note.getTask().getId());
        noteResponse.setContent(note.getContent());
        noteResponse.setCreatedAt(note.getCreatedAt());
        return noteResponse;
    }

    public static Note toEntity(NoteRequest noteRequest) {
        if (noteRequest == null) return null;
        Note note = new Note();
        note.setContent(noteRequest.getContent());
        return note;
    }
}
