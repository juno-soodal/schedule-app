package com.example.scheduleapp.schedule.web;

import com.example.scheduleapp.schedule.application.dto.ScheduleRequestDto;
import com.example.scheduleapp.schedule.application.dto.ScheduleResponseDto;
import com.example.scheduleapp.schedule.application.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> getSchedules(@RequestParam(required = false) String creatorName, @RequestParam(required = false) LocalDate lastModifiedDate) {
        List<ScheduleResponseDto> schedules = scheduleService.getSchedules(creatorName, lastModifiedDate);

        return new ResponseEntity<>(schedules, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> getSchedule(@PathVariable Long id) {
        ScheduleResponseDto findSchedule = scheduleService.getSchedule(id);

        return new ResponseEntity<>(findSchedule, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {
        log.info("scheduleRequestDto = {}", scheduleRequestDto);

        ScheduleResponseDto createdSchedule = scheduleService.createSchedule(scheduleRequestDto);

        return new ResponseEntity<>(createdSchedule,HttpStatus.OK);
    }
}
