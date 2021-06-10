package com.ijse.fitgym.dto;

import com.ijse.fitgym.enums.ActiveAndDeActive;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

public class BranchDTO {

    private long branchId;
    private String branchName;
    private String branchAddress;
    private String contact;
    private String longitude;
    private String latitude;
    private Date date;
    private ActiveAndDeActive state;

    public BranchDTO() {
    }

    public BranchDTO(long branchId, String branchName, String branchAddress, String contact, String longitude, String latitude, Date date, ActiveAndDeActive state) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.contact = contact;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
        this.state = state;
    }

    public long getBranchId() {
        return branchId;
    }

    public void setBranchId(long branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ActiveAndDeActive getState() {
        return state;
    }

    public void setState(ActiveAndDeActive state) {
        this.state = state;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "BranchDTO{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", branchAddress='" + branchAddress + '\'' +
                ", contact='" + contact + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
