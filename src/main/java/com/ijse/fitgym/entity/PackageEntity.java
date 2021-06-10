package com.ijse.fitgym.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_fg_package")
public class PackageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long packageId;
    private String packageName;
    private String packageDescription;
    private long duration;
    private String durationISO;
    private Date date;
    private double fee;
    private Date expDate;

    public PackageEntity() {
    }

    public PackageEntity(String packageName, String packageDescription, long duration, String durationISO, Date date, double fee, Date expDate) {
        this.packageName = packageName;
        this.packageDescription = packageDescription;
        this.duration = duration;
        this.durationISO = durationISO;
        this.date = date;
        this.fee = fee;
        this.expDate = expDate;
    }

    public PackageEntity(String packageName, String packageDescription, long duration, Date date, double fee) {
        this.packageName = packageName;
        this.packageDescription = packageDescription;
        this.duration = duration;
        this.date = date;
        this.fee = fee;
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

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
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

    public String getDurationISO() {
        return durationISO;
    }

    public void setDurationISO(String durationISO) {
        this.durationISO = durationISO;
    }

    @Override
    public String toString() {
        return "PackageEntity{" +
                "packageId=" + packageId +
                ", packageName='" + packageName + '\'' +
                ", packageDescription='" + packageDescription + '\'' +
                ", duration=" + duration +
                ", durationISO='" + durationISO + '\'' +
                ", date=" + date +
                ", fee=" + fee +
                ", expDate=" + expDate +
                '}';
    }
}
