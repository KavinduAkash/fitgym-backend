package com.ijse.fitgym.dto.json.request;

public class ExerciseSaveRequestDTO {
    private String name;
    private String description;
    private long catId;

    public ExerciseSaveRequestDTO() {
    }

    public ExerciseSaveRequestDTO(String name, String description, long catId) {
        this.name = name;
        this.description = description;
        this.catId = catId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getCatId() {
        return catId;
    }

    public void setCatId(long catId) {
        this.catId = catId;
    }

    @Override
    public String toString() {
        return "ExerciseSaveRequestDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", catId=" + catId +
                '}';
    }
}
