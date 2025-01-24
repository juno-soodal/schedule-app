package com.example.scheduleapp.schedule.domain.repository;

import com.example.scheduleapp.schedule.domain.model.Schedule;

import java.time.LocalDate;
import java.util.List;

public interface ScheduleRepository {

    public Schedule save(Schedule schedule);

    public List<Schedule> findAllWithOptionalConditions(String creatorName, LocalDate lastModifiedDate);

    public Schedule findByIdOrElseThrow(Long id);
}
