package com.example.Myshop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Myshop.entities.Payment;
import com.example.Myshop.repository.PaymentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService{
	
	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment addNewPayment(Payment payment) {
		return paymentRepository.save(payment);
	}

}
