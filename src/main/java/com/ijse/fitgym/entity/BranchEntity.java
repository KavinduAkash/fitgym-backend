package com.ijse.fitgym.entity;
import com.ijse.fitgym.enums.ActiveAndDeActive;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_fg_branch")
public class BranchEntity implements java.io.Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long branchId;
    private String branchName;
    private String branchAddress;
    private String longitude;
    private String latitude;
    private String contact;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private ActiveAndDeActive state;

    public BranchEntity() {
    }

    public BranchEntity(String branchName, String branchAddress, String longitude, String latitude, Date date) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.date = date;
    }

    public BranchEntity(String branchName, String branchAddress, String longitude, String latitude, String contact, Date date, ActiveAndDeActive state) {
        this.branchName = branchName;
        this.branchAddress = branchAddress;
        this.longitude = longitude;
        this.latitude = latitude;
        this.contact = contact;
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
        return "BranchEntity{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", branchAddress='" + branchAddress + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", contact='" + contact + '\'' +
                ", date=" + date +
                ", state=" + state +
                '}';
    }
}
