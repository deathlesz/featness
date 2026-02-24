package me.deathlesz.featness.controller;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import me.deathlesz.featness.dto.WorkoutResponse;
import me.deathlesz.featness.entity.Workout;
import me.deathlesz.featness.mapper.WorkoutMapper;
import me.deathlesz.featness.service.WorkoutService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/workouts")
public class WorkoutController {

    private final WorkoutService workoutService;

    public WorkoutController(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    @GetMapping
    public ResponseEntity<List<WorkoutResponse>> getWorkoutsByType(
            @RequestParam(required = false) String type) {

        List<Workout> workouts = workoutService.getWorkoutsByType(type);
        return ResponseEntity.ok(WorkoutMapper.toResponseList(workouts));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkoutResponse> getWorkoutById(
            @PathVariable UUID id) {

        Optional<Workout> workout = workoutService.getWorkoutById(id);
        return workout
                .map(w -> ResponseEntity.ok(WorkoutMapper.toResponse(w)))
                .orElse(ResponseEntity.notFound().build());
    }
}