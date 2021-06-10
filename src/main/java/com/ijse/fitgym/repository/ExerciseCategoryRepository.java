package com.ijse.fitgym.repository;

import com.ijse.fitgym.entity.ExerciseCategoryEntity;
import com.ijse.fitgym.entity.PackageEntity;
import com.ijse.fitgym.enums.ActiveAndDeActive;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExerciseCategoryRepository extends JpaRepository<ExerciseCategoryEntity, Long> {

    @Query("SELECT e FROM ExerciseCategoryEntity e WHERE state = :state")
    List<ExerciseCategoryEntity> getAllActiveExerciseCat(@Param("state") ActiveAndDeActive state);

    @Query("SELECT e FROM ExerciseCategoryEntity e WHERE state = :state")
    List<ExerciseCategoryEntity> getAllDeActiveExerciseCat(@Param("state") ActiveAndDeActive state);
}
