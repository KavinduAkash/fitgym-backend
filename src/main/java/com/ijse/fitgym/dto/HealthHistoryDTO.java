package com.ijse.fitgym.dto;

import com.ijse.fitgym.enums.ActiveAndDeActive;

public class HealthHistoryDTO {

    private long id;
    private String quetion;
    private ActiveAndDeActive state;

    public HealthHistoryDTO() {
    }

    public HealthHistoryDTO(long id, String quetion, ActiveAndDeActive state) {
        this.id = id;
        this.quetion = quetion;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuetion() {
        return quetion;
    }

    public void setQuetion(String quetion) {
        this.quetion = quetion;
    }

    public ActiveAndDeActive getState() {
        return state;
    }

    public void setState(ActiveAndDeActive state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "HealthHistoryDTO{" +
                "id=" + id +
                ", quetion='" + quetion + '\'' +
                ", state=" + state +
                '}';
    }
}
