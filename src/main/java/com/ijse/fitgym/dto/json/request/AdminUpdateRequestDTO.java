package com.ijse.fitgym.dto.json.request;

import com.ijse.fitgym.enums.UserRoles;

public class AdminUpdateRequestDTO {
    private long adminId;
    private String firstName;
    private String lastName;
    private String contact;
    private String email;
    private String userName;
    private String passsword;
    private UserRoles userRoles;
    private long branchId;

    public AdminUpdateRequestDTO() {
    }

    public AdminUpdateRequestDTO(long adminId, String firstName, String lastName, String contact, String email, String userName, String passsword, UserRoles userRoles, long branchId) {
        this.adminId = adminId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contact = contact;
        this.email = email;
        this.userName = userName;
        this.passsword = passsword;
        this.userRoles = userRoles;
        this.branchId = branchId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasssword() {
        return passsword;
    }

    public void setPasssword(String passsword) {
        this.passsword = passsword;
    }

    public UserRoles getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(UserRoles userRoles) {
        this.userRoles = userRoles;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "AdminUpdateRequestDTO{" +
                "adminId=" + adminId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", contact='" + contact + '\'' +
                ", email='" + email + '\'' +
                ", userName='" + userName + '\'' +
                ", passsword='" + passsword + '\'' +
                ", userRoles=" + userRoles +
                ", branchId=" + branchId +
                '}';
    }
}
