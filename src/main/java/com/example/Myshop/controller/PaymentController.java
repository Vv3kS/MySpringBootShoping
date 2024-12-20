package com.example.Myshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myshop.entities.Payment;
import com.example.Myshop.services.PaymentService;
@CrossOrigin("*")
@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired
	private PaymentService paymentService ;
	
	@PostMapping("/addNewPayment")
	public ResponseEntity<Payment> addNewPayment(@RequestBody Payment payment){
		try {
			Payment savedpayment = paymentService.addNewPayment(payment);
			return new ResponseEntity<>(savedpayment,HttpStatus.CREATED);
			
		}catch (Exception e) {
			e.printStackTrace();
			  return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
