package com.ijse.fitgym.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_fg_workout_sheet")
public class WorkoutSheetEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registrationId", referencedColumnName = "registrationId")
    private
    RegistrationEntity registrationEntity;
    @Temporal(TemporalType.TIMESTAMP)
    private
    Date date;
    private long duration;

    public WorkoutSheetEntity() {
    }

    public WorkoutSheetEntity(RegistrationEntity registrationEntity, Date date, long duration) {
        this.registrationEntity = registrationEntity;
        this.date = date;
        this.duration = duration;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RegistrationEntity getRegistrationEntity() {
        return registrationEntity;
    }

    public void setRegistrationEntity(RegistrationEntity registrationEntity) {
        this.registrationEntity = registrationEntity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "WorkoutSheetEntity{" +
                "id=" + id +
                ", registrationEntity=" + registrationEntity +
                ", date=" + date +
                ", duration=" + duration +
                '}';
    }
}
