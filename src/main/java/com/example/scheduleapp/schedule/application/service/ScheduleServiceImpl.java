package com.example.scheduleapp.schedule.application.service;

import com.example.scheduleapp.schedule.application.dto.ScheduleRequestDto;
import com.example.scheduleapp.schedule.application.dto.ScheduleResponseDto;
import com.example.scheduleapp.schedule.application.mapper.ScheduleMapper;
import com.example.scheduleapp.schedule.domain.model.Schedule;
import com.example.scheduleapp.schedule.domain.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;
    private final ScheduleMapper scheduleMapper;

    @Override
    public ScheduleResponseDto createSchedule(ScheduleRequestDto scheduleRequestDto) {
        Schedule savedSchedule = scheduleRepository.save(scheduleMapper.toEntity(scheduleRequestDto));
        return scheduleMapper.toDto(savedSchedule);
    }

    /**
     *
     * @param creatorName (null 가능)
     * @param lastModifiedDate (null 가능)
     * @return
     */
    @Override
    public List<ScheduleResponseDto> getSchedules(String creatorName, LocalDate lastModifiedDate) {
        List<Schedule> schedules = scheduleRepository.findAllWithOptionalConditions(creatorName , lastModifiedDate);
        return schedules.stream().map(scheduleMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ScheduleResponseDto getSchedule(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        return scheduleMapper.toDto(findSchedule);
    }
}
