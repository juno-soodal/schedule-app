package com.example.scheduleapp.schedule.application.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private final Long id;
    private final String toDo;
    private final String creatorName;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;

    public ScheduleResponseDto(Long id, String toDo, String creatorName, LocalDateTime createdDate, LocalDateTime lastModifiedDate) {
        this.id = id;
        this.toDo = toDo;
        this.creatorName = creatorName;
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
    }
}
