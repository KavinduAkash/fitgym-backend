package com.ijse.fitgym.entity;

import com.ijse.fitgym.enums.UserRoles;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="tbl_fg_auth")
public class AuthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long authId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", referencedColumnName = "adminId")
    AdminEntity adminEntity;
    String userName;
    String password;
    UserRoles role;

    public AuthEntity() {
    }

    public AuthEntity(AdminEntity adminEntity, String userName, String password, UserRoles role) {
        this.adminEntity = adminEntity;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public long getAuthId() {
        return authId;
    }

    public void setAuthId(long authId) {
        this.authId = authId;
    }

    public AdminEntity getAdminEntity() {
        return adminEntity;
    }

    public void setAdminEntity(AdminEntity adminEntity) {
        this.adminEntity = adminEntity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRoles getRole() {
        return role;
    }

    public void setRole(UserRoles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "AuthEntity{" +
                "authId=" + authId +
                ", adminEntity=" + adminEntity +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
