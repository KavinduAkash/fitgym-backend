package com.ijse.fitgym.dto.json.request;

public class ExerciseUpdateRequestDTO {
    private long exId;
    private String name;
    private String description;
    private long catId;

    public ExerciseUpdateRequestDTO() {
    }

    public ExerciseUpdateRequestDTO(long exId, String name, String description, long catId) {
        this.exId = exId;
        this.name = name;
        this.description = description;
        this.catId = catId;
    }

    public long getExId() {
        return exId;
    }

    public void setExId(long exId) {
        this.exId = exId;
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
        return "ExerciseUpdateRequestDTO{" +
                "exId=" + exId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", catId=" + catId +
                '}';
    }
}
