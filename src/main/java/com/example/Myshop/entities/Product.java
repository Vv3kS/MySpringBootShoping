package com.example.Myshop.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="products")

public class Product extends IdEntity{
	
	private String p_name ;
	private String p_Description;
	private double price ;
	private int stocks ;
	
	@ManyToOne
	@JoinColumn(name = "cat_id")
	private ProductCategory category ;

	public Product() {
		super();
	}

	public Product(String p_name, String p_Description, double price, int stocks, ProductCategory category) {
		super();
		this.p_name = p_name;
		this.p_Description = p_Description;
		this.price = price;
		this.stocks = stocks;
		this.category = category;
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

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}
	
	

}
