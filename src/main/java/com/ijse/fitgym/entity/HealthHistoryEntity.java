package com.ijse.fitgym.entity;

import com.ijse.fitgym.enums.ActiveAndDeActive;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fg_health_history")
public class HealthHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String question;
    private ActiveAndDeActive state;

    public HealthHistoryEntity() {
    }

    public HealthHistoryEntity(String question, ActiveAndDeActive state) {
        this.question = question;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ActiveAndDeActive getState() {
        return state;
    }

    public void setState(ActiveAndDeActive state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "HealthHistoryEntity{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", state=" + state +
                '}';
    }
}
