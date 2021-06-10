package com.ijse.fitgym.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_fg_payment")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long paymentId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "adminId", referencedColumnName = "adminId")
    private AdminEntity adminEntity;
    private double amount;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    public PaymentEntity() {
    }

    public PaymentEntity(AdminEntity adminEntity, double amount, Date date) {
        this.adminEntity = adminEntity;
        this.amount = amount;
        this.date = date;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public AdminEntity getAdminEntity() {
        return adminEntity;
    }

    public void setAdminEntity(AdminEntity adminEntity) {
        this.adminEntity = adminEntity;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "PaymentEntity{" +
                "paymentId=" + paymentId +
                ", adminEntity=" + adminEntity +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
