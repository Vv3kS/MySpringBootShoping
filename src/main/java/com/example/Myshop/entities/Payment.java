package com.example.Myshop.entities;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "payments")
public class Payment extends IdEntity {

    private double amount;
    private LocalDate paymentDate;

    @Enumerated(EnumType.STRING)  // Store the enum as a string in the DB
    private payType mode;

    // Constructors, getters, setters
    public Payment() {
        super();
    }

    public Payment(double amount, LocalDate paymentDate, payType mode) {
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.mode = mode;
    }

    // Getters and setters
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public payType getMode() {
        return mode;
    }

    public void setMode(payType mode) {
        this.mode = mode;
    }

    @Override
    public String toString() {
        return "Payment [id=" + getId() + ", amount=" + amount + ", paymentDate=" + paymentDate + ", mode=" + mode + "]";
    }
}
