package com.ijse.fitgym.dto;

import com.ijse.fitgym.enums.MemberHealthHistoryState;

public class MemberHealthHistoryDTO {
    private long id;
    private HealthHistoryDTO healthHistoryDTO;
    private MemberHealthHistoryState state;

    public MemberHealthHistoryDTO() {
    }

    public MemberHealthHistoryDTO(long id, HealthHistoryDTO healthHistoryDTO, MemberHealthHistoryState state) {
        this.id = id;
        this.healthHistoryDTO = healthHistoryDTO;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HealthHistoryDTO getHealthHistoryDTO() {
        return healthHistoryDTO;
    }

    public void setHealthHistoryDTO(HealthHistoryDTO healthHistoryDTO) {
        this.healthHistoryDTO = healthHistoryDTO;
    }

    public MemberHealthHistoryState getState() {
        return state;
    }

    public void setState(MemberHealthHistoryState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MemberHealthHistoryDTO{" +
                "id=" + id +
                ", healthHistoryDTO=" + healthHistoryDTO +
                ", state=" + state +
                '}';
    }
}
