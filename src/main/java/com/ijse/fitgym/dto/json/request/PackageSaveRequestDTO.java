package com.ijse.fitgym.dto.json.request;

import java.util.Date;

public class PackageSaveRequestDTO {
    private String name;
    private String description;
    private String duration;
    private double fee;

    public PackageSaveRequestDTO() {
    }

    public PackageSaveRequestDTO(String name, String description, String duration, double fee) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        this.fee = fee;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "PackageSaveRequestDTO{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", duration=" + duration +
                ", fee=" + fee +
                '}';
    }
}
