package com.ijse.fitgym.dto;

import com.ijse.fitgym.enums.MemberRoles;

import java.util.Date;

public class MemberDTO {
    private long memberId;
    private String firatName;
    private String lastName;
    private Date DOB;
    private String address;
    private String cellContact;
    private String homeContact;
    private String emergencyContact;
    private String email;
    private MemberRoles role;

    public MemberDTO() {
    }

    public MemberDTO(long memberId, String firatName, String lastName, Date DOB, String address, String cellContact, String homeContact, String emergencyContact, String email, MemberRoles role) {
        this.memberId = memberId;
        this.firatName = firatName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.address = address;
        this.cellContact = cellContact;
        this.homeContact = homeContact;
        this.emergencyContact = emergencyContact;
        this.email = email;
        this.role = role;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getFiratName() {
        return firatName;
    }

    public void setFiratName(String firatName) {
        this.firatName = firatName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCellContact() {
        return cellContact;
    }

    public void setCellContact(String cellContact) {
        this.cellContact = cellContact;
    }

    public String getHomeContact() {
        return homeContact;
    }

    public void setHomeContact(String homeContact) {
        this.homeContact = homeContact;
    }

    public String getEmergencyContact() {
        return emergencyContact;
    }

    public void setEmergencyContact(String emergencyContact) {
        this.emergencyContact = emergencyContact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MemberRoles getRole() {
        return role;
    }

    public void setRole(MemberRoles role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "memberId=" + memberId +
                ", firatName='" + firatName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", address='" + address + '\'' +
                ", cellContact='" + cellContact + '\'' +
                ", homeContact='" + homeContact + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }
}
