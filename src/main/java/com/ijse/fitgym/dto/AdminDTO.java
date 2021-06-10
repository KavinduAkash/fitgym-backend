package com.ijse.fitgym.dto;

import com.ijse.fitgym.enums.UserRoles;

public class AdminDTO {

    private long adminId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private UserRoles userRoles;
    private BranchDTO branchDTO;
    private String userName;

    public AdminDTO() {
    }

    public AdminDTO(long adminId, String firstName, String lastName, String contact, String email, UserRoles userRoles) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.userRoles = userRoles;
    }

    public AdminDTO(long adminId, String firstName, String lastName, String contact, String email, UserRoles userRoles, BranchDTO branchDTO, String userName) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.userRoles = userRoles;
        this.branchDTO = branchDTO;
        this.userName = userName;
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

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

    public BranchDTO getBranchDTO() {
        return branchDTO;
    }

    public void setBranchDTO(BranchDTO branchDTO) {
        this.branchDTO = branchDTO;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "AdminDTO{" +
                "adminId=" + adminId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", userRoles=" + userRoles +
                ", branchDTO=" + branchDTO +
                ", userName='" + userName + '\'' +
                '}';
    }
}
