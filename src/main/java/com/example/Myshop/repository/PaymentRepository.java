package com.example.Myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Myshop.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {

}