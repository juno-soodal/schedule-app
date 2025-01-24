package com.example.scheduleapp.schedule.domain.model;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
public class Schedule {

    //기본 식별자
    @Setter
    private Long id;
    private final String toDo;
    private final String creatorName;
    private final String password;
    private final LocalDateTime createdDate;
    private final LocalDateTime lastModifiedDate;

    public Schedule(String toDo, String creatorName, String password) {
        this.toDo = toDo;
        this.creatorName = creatorName;
        this.password = password;
        this.createdDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }
}
