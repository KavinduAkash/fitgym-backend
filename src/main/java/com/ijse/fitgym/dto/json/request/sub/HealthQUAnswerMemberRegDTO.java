package com.ijse.fitgym.dto.json.request.sub;

public class HealthQUAnswerMemberRegDTO {
    private long id;
    private boolean state;

    public HealthQUAnswerMemberRegDTO() {
    }

    public HealthQUAnswerMemberRegDTO(long id, boolean state) {
        this.id = id;
        this.state = state;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "healthQUAnswerMemberRegDTO{" +
                "id=" + id +
                ", state=" + state +
                '}';
    }
}
