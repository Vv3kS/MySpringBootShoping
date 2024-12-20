package com.example.Myshop.dto;

import java.time.LocalDate;

import com.example.Myshop.entities.Status;



public class OrderDto extends Iddto {

	
	private Status status ;
	private Long user_Id ;
	private Long product_id ;
	private Long payment_id ;
	private LocalDate purchaseDate;
	public OrderDto() {
		super();
	}
	public OrderDto(Status status, Long user_Id, Long product_id, Long payment_id, LocalDate purchaseDate) {
		super();
		this.status = status;
		this.user_Id = user_Id;
		this.product_id = product_id;
		this.payment_id = payment_id;
		this.purchaseDate = purchaseDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Long getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(Long user_Id) {
		this.user_Id = user_Id;
	}
	public Long getProduct_id() {
		return product_id;
	}
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	public Long getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(Long payment_id) {
		this.payment_id = payment_id;
	}
	public LocalDate getPurchaseDate() {
		return purchaseDate;
	}
	public void setPurchaseDate(LocalDate purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	@Override
	public String toString() {
		return "OrderDto [status=" + status + ", user_Id=" + user_Id + ", product_id=" + product_id + ", payment_id="
				+ payment_id + ", purchaseDate=" + purchaseDate + "]";
	}
	
	
}
