package com.example.Myshop.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="orders")
public class Order extends IdEntity{
	
	@Enumerated(EnumType.STRING)
	private Status status ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_Id")
	private User user ;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="product_id")
	private Product product ;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="payment_id")
	private Payment payment ;
	
	private LocalDate purchaseDate;
	
		public Order() {
		
			}

		public Order(Status status, User user, Product product, Payment payment, LocalDate purchaseDate) {
			super();
			this.status = status;
			this.user = user;
			this.product = product;
			this.payment = payment;
			this.purchaseDate = purchaseDate;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public Product getProduct() {
			return product;
		}

		public void setProduct(Product product) {
			this.product = product;
		}

		public Payment getPayment() {
			return payment;
		}

		public void setPayment(Payment payment) {
			this.payment = payment;
		}

		public LocalDate getPurchaseDate() {
			return purchaseDate;
		}

		public void setPurchaseDate(LocalDate purchaseDate) {
			this.purchaseDate = purchaseDate;
		}
		
		
		

	
	

}
