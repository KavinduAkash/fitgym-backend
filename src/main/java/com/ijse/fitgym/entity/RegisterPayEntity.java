package com.ijse.fitgym.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_fg_reg_pay")
public class RegisterPayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "registrationId", referencedColumnName = "registrationId")
    RegistrationEntity registrationEntity;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paymentId", referencedColumnName = "paymentId")
    PaymentEntity paymentEntity;
    double amount;
    Date date;

}
