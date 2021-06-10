package com.ijse.fitgym.dto;

import com.ijse.fitgym.enums.ActiveAndDeActive;

public class ExerciseDTO {
    private long exerciseId;
    private String exerciseName;
    private String exerciseDescription;
    private ExerciseCategoryDTO exerciseCategoryDTO;
    private ActiveAndDeActive state;

    public ExerciseDTO() {
    }

    public ExerciseDTO(long exerciseId, String exerciseName, String exerciseDescription, ExerciseCategoryDTO exerciseCategoryDTO, ActiveAndDeActive state) {
        this.exerciseId = exerciseId;
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.exerciseCategoryDTO = exerciseCategoryDTO;
        this.state = state;
    }

    public long getExerciseId() {
        return exerciseId;
    }

    public void setExerciseId(long exerciseId) {
        this.exerciseId = exerciseId;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public String getExerciseDescription() {
        return exerciseDescription;
    }

    public void setExerciseDescription(String exerciseDescription) {
        this.exerciseDescription = exerciseDescription;
    }

    public ExerciseCategoryDTO getExerciseCategoryDTO() {
        return exerciseCategoryDTO;
    }

    public void setExerciseCategoryDTO(ExerciseCategoryDTO exerciseCategoryDTO) {
        this.exerciseCategoryDTO = exerciseCategoryDTO;
    }

    public ActiveAndDeActive getState() {
        return state;
    }

    public void setState(ActiveAndDeActive state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ExerciseDTO{" +
                "exerciseId=" + exerciseId +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseDescription='" + exerciseDescription + '\'' +
                ", exerciseCategoryDTO=" + exerciseCategoryDTO +
                ", state=" + state +
                '}';
    }
}
