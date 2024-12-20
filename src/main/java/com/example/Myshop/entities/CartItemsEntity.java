package com.example.Myshop.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart_items")
public class CartItemsEntity extends IdEntity {
	
	@ManyToOne
	@JoinColumn(name="cart_id", nullable = false)
	private CartEntity cart;

	@ManyToOne
	@JoinColumn(name="product_id",nullable = false)
	private Product product;
	
	@Column(nullable = false)
	private int quantity;

	public CartItemsEntity() {
		super();
	}

	public CartItemsEntity(CartEntity cart, Product product, int quantity) {
		super();
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
	}

	public CartEntity getCart() {
		return cart;
	}

	public void setCart(CartEntity cart) {
		this.cart = cart;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "CartItemsEntity [cart=" + cart + ", product=" + product + ", quantity=" + quantity + "]";
	}
	
	
}
