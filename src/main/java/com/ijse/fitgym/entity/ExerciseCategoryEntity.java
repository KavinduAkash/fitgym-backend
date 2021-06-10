package com.ijse.fitgym.entity;

import com.ijse.fitgym.enums.ActiveAndDeActive;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fg_exercise_category")
public class ExerciseCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long catId;
    private String categoryName;
    private String categoryDescription;
    private ActiveAndDeActive state;

    public ExerciseCategoryEntity() {
    }

    public ExerciseCategoryEntity(String categoryName, String categoryDescription, ActiveAndDeActive state) {
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
        this.state = state;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public ActiveAndDeActive getState() {
        return state;
    }

    public void setState(ActiveAndDeActive state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "ExerciseCategoryEntity{" +
                "catId=" + catId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", state=" + state +
                '}';
    }
}
