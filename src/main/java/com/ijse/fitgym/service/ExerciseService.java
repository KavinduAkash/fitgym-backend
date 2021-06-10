package com.ijse.fitgym.service;

import com.ijse.fitgym.dto.ExerciseDTO;
import com.ijse.fitgym.dto.json.request.ExerciseSaveRequestDTO;
import com.ijse.fitgym.dto.json.request.ExerciseUpdateRequestDTO;

import java.util.List;

public interface ExerciseService {
    List<ExerciseDTO> createNewExercise(ExerciseSaveRequestDTO dto);
    List<ExerciseDTO> getAllExercise();
    List<ExerciseDTO> getAciveExercise();
    List<ExerciseDTO> getDeAciveExercise();
    List<ExerciseDTO> changeActivationExercise(long id);
    List<ExerciseDTO> updateExercise(ExerciseUpdateRequestDTO dto);
}
