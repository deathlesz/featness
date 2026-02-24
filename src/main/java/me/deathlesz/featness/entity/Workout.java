package me.deathlesz.featness.entity;

import java.time.LocalDateTime;
import java.util.UUID;

public class Workout {
    private UUID id;

    private String name;
    private WorkoutType type;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private int caloriesBurned;

    public Workout() {}

    public Workout(UUID id, String name, WorkoutType type,
                   LocalDateTime startTime, LocalDateTime endTime,
                   int caloriesBurned) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.startTime = startTime;
        this.endTime = endTime;
        this.caloriesBurned = caloriesBurned;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkoutType getType() {
        return type;
    }

    public void setType(WorkoutType type) {
        this.type = type;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }
}

