package com.ijse.fitgym.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fg_workouts")
public class WorkoutsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workoutSheetId", referencedColumnName = "id")
    private WorkoutSheetEntity workoutSheetEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exerciseId", referencedColumnName = "exerciseId")
    private ExerciseEntity exerciseEntity;
    private int set_count;
    private int repeat_count;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public WorkoutSheetEntity getWorkoutSheetEntity() {
        return workoutSheetEntity;
    }

    public void setWorkoutSheetEntity(WorkoutSheetEntity workoutSheetEntity) {
        this.workoutSheetEntity = workoutSheetEntity;
    }

    public ExerciseEntity getExerciseEntity() {
        return exerciseEntity;
    }

    public void setExerciseEntity(ExerciseEntity exerciseEntity) {
        this.exerciseEntity = exerciseEntity;
    }

    public int getSet_count() {
        return set_count;
    }

    public void setSet_count(int set_count) {
        this.set_count = set_count;
    }

    public int getRepeat_count() {
        return repeat_count;
    }

    public void setRepeat_count(int repeat_count) {
        this.repeat_count = repeat_count;
    }
}
