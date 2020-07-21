package com.lucasalencar.cursomc.domain;

import com.lucasalencar.cursomc.domain.enums.PaymentStatus;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PaymentBoleto extends Payment{

    private static final long serialVersionUID = 1L;

    private Date expirationDate;
    private Date paymentDate;

    public PaymentBoleto(){}

    public PaymentBoleto(Integer id, PaymentStatus status, Order order, Date expirationDate, Date paymentDate) {
        super(id, status, order);
        this.expirationDate = expirationDate;
        this.paymentDate = paymentDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}

