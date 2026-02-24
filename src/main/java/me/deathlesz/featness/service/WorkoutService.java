package me.deathlesz.featness.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import me.deathlesz.featness.entity.Workout;
import me.deathlesz.featness.entity.WorkoutType;
import me.deathlesz.featness.repository.WorkoutRepository;
import org.springframework.stereotype.Service;

@Service
public class WorkoutService {

    private final WorkoutRepository workoutRepository;

    public WorkoutService(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    public Optional<Workout> getWorkoutById(UUID id) {
        return workoutRepository.findById(id);
    }

    public List<Workout> getWorkoutsByType(String type) {
        if (type == null || type.isBlank()) {
            return workoutRepository.findAll();
        }

        try {
            WorkoutType workoutType = WorkoutType.valueOf(type.toUpperCase());

            return workoutRepository.findByType(workoutType);
        } catch (IllegalArgumentException e) {
            return List.of();
        }
    }
}