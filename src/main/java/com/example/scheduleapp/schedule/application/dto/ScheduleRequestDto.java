package com.example.scheduleapp.schedule.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
public class ScheduleRequestDto {

    private final String toDo;
    private final String creatorName;
    private final String password;

    public ScheduleRequestDto(String toDo, String creatorName, String password) {
        this.toDo = toDo;
        this.creatorName = creatorName;
        this.password = password;
    }
}
