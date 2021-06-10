package com.ijse.fitgym.entity;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fg_health_measure")
public class HealthMeasureEntity {

    @Id
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "workoutSheetId", referencedColumnName = "id")
    private
    WorkoutSheetEntity workoutSheetEntity;
    private double fat;
    private double height;
    private double weight;

    public HealthMeasureEntity() {
    }

    public HealthMeasureEntity(long id, WorkoutSheetEntity workoutSheetEntity, double fat, double height, double weight) {
        this.id = id;
        this.workoutSheetEntity = workoutSheetEntity;
        this.fat = fat;
        this.height = height;
        this.weight = weight;
    }

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

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HealthMeasureEntity{" +
                "id=" + id +
                ", workoutSheetEntity=" + workoutSheetEntity +
                ", fat=" + fat +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
