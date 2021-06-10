package com.ijse.fitgym.dto.json.request;

public class HealthQuetionSaveRequestDTO {
    private String quetion;

    public HealthQuetionSaveRequestDTO() {
    }

    public HealthQuetionSaveRequestDTO(String quetion) {
        this.quetion = quetion;
    }

    public String getQuetion() {
        return quetion;
    }

    public void setQuetion(String quetion) {
        this.quetion = quetion;
    }

    @Override
    public String toString() {
        return "HealthQuetionSaveRequestDTO{" +
                "quetion='" + quetion + '\'' +
                '}';
    }
}
