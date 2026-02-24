package me.deathlesz.featness.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import me.deathlesz.featness.entity.Workout;
import me.deathlesz.featness.entity.WorkoutType;
import org.springframework.stereotype.Repository;

@Repository
public class WorkoutRepository {

    private final List<Workout> workouts = List.of(
            new Workout(
                    UUID.fromString("a1b2c3d4-0001-4000-8000-000000000001"),
                    "Morning Run",
                    WorkoutType.CARDIO,
                    LocalDateTime.of(2025, 1, 10, 6, 0),
                    LocalDateTime.of(2025, 1, 10, 6, 30),
                    300
            ),
            new Workout(
                    UUID.fromString("a1b2c3d4-0002-4000-8000-000000000002"),
                    "Bench Press",
                    WorkoutType.STRENGTH,
                    LocalDateTime.of(2025, 1, 11, 17, 0),
                    LocalDateTime.of(2025, 1, 11, 17, 45),
                    250
            ),
            new Workout(
                    UUID.fromString("a1b2c3d4-0003-4000-8000-000000000003"),
                    "Yoga Flow",
                    WorkoutType.FLEXIBILITY,
                    LocalDateTime.of(2025, 1, 12, 8, 0),
                    LocalDateTime.of(2025, 1, 12, 9, 15),
                    180
            ),
            new Workout(
                    UUID.fromString("a1b2c3d4-0004-4000-8000-000000000004"),
                    "HIIT Session",
                    WorkoutType.HIIT,
                    LocalDateTime.of(2025, 1, 13, 12, 0),
                    LocalDateTime.of(2025, 1, 13, 12, 25),
                    400
            ),
            new Workout(
                    UUID.fromString("a1b2c3d4-0005-4000-8000-000000000005"),
                    "Deadlift Day",
                    WorkoutType.STRENGTH,
                    LocalDateTime.of(2025, 1, 14, 18, 0),
                    LocalDateTime.of(2025, 1, 14, 18, 50),
                    320
            )
    );

    public List<Workout> findAll() {
        return workouts;
    }

    public Optional<Workout> findById(UUID id) {
        return workouts.stream()
                .filter(w -> w.getId().equals(id))
                .findFirst();
    }

    public List<Workout> findByType(WorkoutType type) {
        return workouts.stream()
                .filter(w -> w.getType() == type)
                .toList();
    }
}