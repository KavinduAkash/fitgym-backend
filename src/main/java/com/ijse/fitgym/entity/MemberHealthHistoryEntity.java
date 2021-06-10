package com.ijse.fitgym.entity;

import com.ijse.fitgym.enums.MemberHealthHistoryState;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fg_member_health_history")
public class MemberHealthHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "memberId", referencedColumnName = "memberId")
    private MemberEntity memberEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "healthHisId", referencedColumnName = "id")
    private HealthHistoryEntity healthHistoryEntity;
    private MemberHealthHistoryState state;

    public MemberHealthHistoryEntity() {
    }

    public MemberHealthHistoryEntity(MemberEntity memberEntity, HealthHistoryEntity healthHistoryEntity, MemberHealthHistoryState state) {
        this.memberEntity = memberEntity;
        this.healthHistoryEntity = healthHistoryEntity;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MemberEntity getMemberEntity() {
        return memberEntity;
    }

    public void setMemberEntity(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }

    public HealthHistoryEntity getHealthHistoryEntity() {
        return healthHistoryEntity;
    }

    public void setHealthHistoryEntity(HealthHistoryEntity healthHistoryEntity) {
        this.healthHistoryEntity = healthHistoryEntity;
    }

    public MemberHealthHistoryState getState() {
        return state;
    }

    public void setState(MemberHealthHistoryState state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "MemberHealthHistoryEntity{" +
                "id=" + id +
                ", memberEntity=" + memberEntity +
                ", healthHistoryEntity=" + healthHistoryEntity +
                ", state=" + state +
                '}';
    }
}
