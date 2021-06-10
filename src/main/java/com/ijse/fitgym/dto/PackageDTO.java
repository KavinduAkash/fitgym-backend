package com.ijse.fitgym.dto;

import java.util.Date;

public class PackageDTO {

    private long packageId;
    private String packageName;
    private String packageDescription;
    private String duration;
    private Date date;
    private double fee;
    private Date expDate;

    public PackageDTO() {
    }

    public PackageDTO(long packageId, String packageName, String packageDescription, String duration, Date date, double fee, Date expDate) {
        this.packageId = packageId;
        this.packageName = packageName;
        this.packageDescription = packageDescription;
        this.duration = duration;
        this.date = date;
        this.fee = fee;
        this.expDate = expDate;
    }

    public long getPackageId() {
        return packageId;
    }

    public void setPackageId(long packageId) {
        this.packageId = packageId;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getPackageDescription() {
        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {
        this.packageDescription = packageDescription;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    @Override
    public String toString() {
        return "PackageDTO{" +
                "packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", packageDescription='" + packageDescription + '\'' +
                ", duration=" + duration +
                ", date=" + date +
                ", fee=" + fee +
                ", expDate=" + expDate +
                '}';
    }
}
