package com.ijse.fitgym.dto;

import com.ijse.fitgym.enums.ActiveAndDeActive;

public class ExerciseCategoryDTO {
    private long catId;
    private String categoryName;
    private String categoryDescription;
    private ActiveAndDeActive state;

    public ExerciseCategoryDTO() {
    }

    public ExerciseCategoryDTO(long catId, String categoryName, String categoryDescription, ActiveAndDeActive state) {
        this.catId = catId;
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
        return "ExerciseCategoryDTO{" +
                "catId=" + catId +
                ", categoryName='" + categoryName + '\'' +
                ", categoryDescription='" + categoryDescription + '\'' +
                ", state=" + state +
                '}';
    }
}
