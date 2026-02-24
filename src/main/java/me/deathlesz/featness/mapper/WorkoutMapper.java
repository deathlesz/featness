package me.deathlesz.featness.mapper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import me.deathlesz.featness.dto.WorkoutResponse;
import me.deathlesz.featness.entity.Workout;

public final class WorkoutMapper {

    private WorkoutMapper() {}

    public static WorkoutResponse toResponse(Workout workout) {
        WorkoutResponse response = new WorkoutResponse();

        response.setId(workout.getId().toString());
        response.setName(workout.getName());
        response.setType(workout.getType().name().toLowerCase());
        response.setStartTime(workout.getStartTime().toString());
        response.setEndTime(workout.getEndTime().toString());
        response.setDuration(formatDuration(workout.getStartTime(), workout.getEndTime()));
        response.setCaloriesBurned(workout.getCaloriesBurned());

        return response;
    }

    public static List<WorkoutResponse> toResponseList(List<Workout> workouts) {
        return workouts.stream()
                .map(WorkoutMapper::toResponse)
                .toList();
    }

    private static String formatDuration(LocalDateTime start,
                                         LocalDateTime end) {
        Duration duration = Duration.between(start, end);
        long hours = duration.toHours();
        long minutes = duration.toMinutesPart();

        if (hours > 0 && minutes > 0) {
            return hours + "h " + minutes + "min";
        } else if (hours > 0) {
            return hours + "h";
        } else {
            return minutes + "min";
        }
    }
}