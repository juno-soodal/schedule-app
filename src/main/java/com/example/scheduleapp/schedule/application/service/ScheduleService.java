package com.example.scheduleapp.schedule.application.service;

import com.example.scheduleapp.schedule.application.dto.ScheduleRequestDto;
import com.example.scheduleapp.schedule.application.dto.ScheduleResponseDto;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto);

    List<ScheduleResponseDto> getSchedules(String creatorName, LocalDate lastModifiedDate);

    ScheduleResponseDto getSchedule(Long id);
}
