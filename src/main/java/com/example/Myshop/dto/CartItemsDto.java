package com.example.Myshop.dto;

import com.example.Myshop.entities.CartEntity;
import com.example.Myshop.entities.Product;

public class CartItemsDto extends Iddto {
	
	private Product product ;
	private CartEntity cart ;
	private int quantity ;
	public CartItemsDto() {
		super();
	}
	public CartItemsDto(Product product, CartEntity cart, int quantity) {
		super();
		this.product = product;
		this.cart = cart;
		this.quantity = quantity;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public CartEntity getCart() {
		return cart;
	}
	public void setCart(CartEntity cart) {
		this.cart = cart;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItemsDto [product=" + product + ", cart=" + cart + ", quantity=" + quantity + "]";
	}
	
	

}
