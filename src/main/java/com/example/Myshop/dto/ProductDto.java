package com.example.Myshop.dto;

import lombok.Data;


public class ProductDto extends Iddto {
	private String p_name ;
	private String p_Description;
	private double price ;
	private int stocks ;
	
	private Long category_id;

	
	public ProductDto() {
		super();
	}


	public ProductDto(String p_name, String p_Description, double price, int stocks, Long category_id) {
		super();
		this.p_name = p_name;
		this.p_Description = p_Description;
		this.price = price;
		this.stocks = stocks;
		this.category_id = category_id;
	}


	public String getP_name() {
		return p_name;
	}


	public void setP_name(String p_name) {
		this.p_name = p_name;
	}


	public String getP_Description() {
		return p_Description;
	}


	public void setP_Description(String p_Description) {
		this.p_Description = p_Description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public int getStocks() {
		return stocks;
	}


	public void setStocks(int stocks) {
		this.stocks = stocks;
	}


	public Long getCategory_id() {
		return category_id;
	}


	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	
	
}

