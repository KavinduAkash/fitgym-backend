package com.ijse.fitgym.repository;

import com.ijse.fitgym.entity.ExerciseEntity;
import com.ijse.fitgym.enums.ActiveAndDeActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {
    @Query("SELECT e FROM ExerciseEntity e WHERE state = :state")
    List<ExerciseEntity> getAllActiveExercise(@Param("state") ActiveAndDeActive state);

    @Query("SELECT e FROM ExerciseEntity e WHERE state = :state")
    List<ExerciseEntity> getAllDeActiveExercise(@Param("state") ActiveAndDeActive state);
}
