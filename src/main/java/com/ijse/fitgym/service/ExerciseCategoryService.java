package com.ijse.fitgym.service;

import com.ijse.fitgym.dto.ExerciseCategoryDTO;
import com.ijse.fitgym.dto.json.request.ExerciseCategorySaveRequestDTO;

import java.util.List;

public interface ExerciseCategoryService {
    List<ExerciseCategoryDTO> createNewExerciseCategory(ExerciseCategorySaveRequestDTO dto);
    List<ExerciseCategoryDTO> updateExerciseCategory(ExerciseCategoryDTO dto);
    List<ExerciseCategoryDTO> getAllExerciseCategory();
    List<ExerciseCategoryDTO> getAllActiveExerciseCategory();
    List<ExerciseCategoryDTO> getAllDeActiveExerciseCategory();
    List<ExerciseCategoryDTO> deActiveExerciseCategory(long id);
}
