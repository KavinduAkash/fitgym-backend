package com.ijse.fitgym.entity;

import com.ijse.fitgym.enums.ActiveAndDeActive;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fg_exercise")
public class ExerciseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long exerciseId;
    private String exerciseName;
    private String exerciseDescription;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "catId", referencedColumnName = "catId")
    private ExerciseCategoryEntity categoryEntity;
    private ActiveAndDeActive state;

    public ExerciseEntity() {
    }

    public ExerciseEntity(String exerciseName, String exerciseDescription, ExerciseCategoryEntity categoryEntity, ActiveAndDeActive state) {
        this.exerciseName = exerciseName;
        this.exerciseDescription = exerciseDescription;
        this.categoryEntity = categoryEntity;
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

    public ExerciseCategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public void setCategoryEntity(ExerciseCategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public ActiveAndDeActive getState() {
        return state;
    }

    public void setState(ActiveAndDeActive state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ExerciseEntity{" +
                "exerciseId=" + exerciseId +
                ", exerciseName='" + exerciseName + '\'' +
                ", exerciseDescription='" + exerciseDescription + '\'' +
                ", categoryEntity=" + categoryEntity +
                ", state=" + state +
                '}';
    }
}
