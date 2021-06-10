package com.ijse.fitgym.dto.json.request;

import com.ijse.fitgym.dto.json.request.sub.HealthQUAnswerMemberRegDTO;

import java.util.Date;
import java.util.List;

public class MemberRegistrationRequestDTO {
    private long memberId;
    private String firatName;
    private String lastName;
    private Date DOB;
    private String address;
    private String cellContact;
    private String homeContact;
    private String emergencyContact;
    private String email;
    private List<HealthQUAnswerMemberRegDTO> memberHistoryArray;
    private long packageId;

    public MemberRegistrationRequestDTO() {
    }

    public MemberRegistrationRequestDTO(long memberId, String firatName, String lastName, Date DOB, String address, String cellContact, String homeContact, String emergencyContact, String email, List<HealthQUAnswerMemberRegDTO> memberHistoryArray, long packageId) {
        this.memberId = memberId;
        this.firatName = firatName;
        this.lastName = lastName;
        this.DOB = DOB;
        this.address = address;
        this.cellContact = cellContact;
        this.homeContact = homeContact;
        this.emergencyContact = emergencyContact;
        this.email = email;
        this.memberHistoryArray = memberHistoryArray;
        this.packageId = packageId;
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

    public List<HealthQUAnswerMemberRegDTO> getMemberHistoryArray() {
        return memberHistoryArray;
    }

    public void setMemberHistoryArray(List<HealthQUAnswerMemberRegDTO> memberHistoryArray) {
        this.memberHistoryArray = memberHistoryArray;
    }

    public long getPackageId() {
        return packageId;
    }

    public void setPackageId(long packageId) {
        this.packageId = packageId;
    }

    @Override
    public String toString() {
        return "MemberRegistrationRequestDTO{" +
                "memberId=" + memberId +
                ", firatName='" + firatName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", DOB=" + DOB +
                ", address='" + address + '\'' +
                ", cellContact='" + cellContact + '\'' +
                ", homeContact='" + homeContact + '\'' +
                ", emergencyContact='" + emergencyContact + '\'' +
                ", email='" + email + '\'' +
                ", memberHistoryArray=" + memberHistoryArray +
                ", packageId=" + packageId +
                '}';
    }
}
