package com.ijse.fitgym.entity;

import com.ijse.fitgym.enums.UserActiveState;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "tbl_fg_admin_user")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long adminId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    @ManyToOne(cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    @JoinColumn(name = "branchId")
    private BranchEntity branchEntity;
    private UserActiveState state;

    public AdminEntity() {
    }

    public AdminEntity(String firstName, String lastName, String contact, String email, BranchEntity branchEntity, UserActiveState state) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.branchEntity = branchEntity;
        this.state = state;
    }

    public long getAdminId() {
        return adminId;
    }

    public void setAdminId(long adminId) {
        this.adminId = adminId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserActiveState getState() {
        return state;
    }

    public void setState(UserActiveState state) {
        this.state = state;
    }

    public BranchEntity getBranchEntity() {
        return branchEntity;
    }

    public void setBranchEntity(BranchEntity branchEntity) {
        this.branchEntity = branchEntity;
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "adminId=" + adminId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", branchEntity=" + branchEntity +
                ", state=" + state +
                '}';
    }
}
