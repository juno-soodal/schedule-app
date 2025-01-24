package com.example.scheduleapp.schedule.domain.repository;

import com.example.scheduleapp.schedule.domain.model.Schedule;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Repository
public class MemoryScheduleRepository implements ScheduleRepository{

    private static final Map<Long, Schedule> store = new ConcurrentHashMap<>();
    private static AtomicLong sequence = new AtomicLong(0L);

    @Override
    public Schedule save(Schedule schedule) {
        long id = sequence.incrementAndGet();
        schedule.setId(id);
        store.put(id, schedule);
        return schedule;
    }

    @Override
    public List<Schedule> findAllWithOptionalConditions(String creatorName, LocalDate lastModifiedDate) {
        Stream<Schedule> stream = store.values().stream();
        if (creatorName != null) {
            stream = stream.filter(schedule -> Objects.equals(creatorName, schedule.getCreatorName()));
        }
        if (lastModifiedDate != null) {
            stream = stream.filter(schedule -> Optional.ofNullable(schedule.getLastModifiedDate()).map(localDateTime -> localDateTime.toLocalDate().isEqual(lastModifiedDate)).orElse(false));
        }
        return stream.toList();
    }

    @Override
    public Schedule findByIdOrElseThrow(Long id) {
        return Optional.ofNullable(store.get(id)).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST,"없는 아이디입니다."));
    }

}
