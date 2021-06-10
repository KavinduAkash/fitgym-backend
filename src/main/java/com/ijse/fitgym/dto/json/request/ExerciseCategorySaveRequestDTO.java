package com.ijse.fitgym.dto.json.request;

public class ExerciseCategorySaveRequestDTO {
    private String name;
    private String description;

    public ExerciseCategorySaveRequestDTO() {
    }

    public ExerciseCategorySaveRequestDTO(String name, String description) {
        this.name = name;
        this.description = description;
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

    @Override
    public String toString() {
        return "ExerciseCategorySaveRequestDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
