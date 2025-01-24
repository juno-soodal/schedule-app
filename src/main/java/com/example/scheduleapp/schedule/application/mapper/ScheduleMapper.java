package com.example.scheduleapp.schedule.application.mapper;

import com.example.scheduleapp.schedule.application.dto.ScheduleRequestDto;
import com.example.scheduleapp.schedule.application.dto.ScheduleResponseDto;
import com.example.scheduleapp.schedule.domain.model.Schedule;
import org.springframework.stereotype.Component;

@Component
public class ScheduleMapper {

    public ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getToDo(), schedule.getCreatorName(), schedule.getCreatedDate(), schedule.getLastModifiedDate());
    }

    public Schedule toEntity(ScheduleRequestDto scheduleRequestDto) {
        return new Schedule(scheduleRequestDto.getToDo(), scheduleRequestDto.getCreatorName(), scheduleRequestDto.getPassword());
    }


}
