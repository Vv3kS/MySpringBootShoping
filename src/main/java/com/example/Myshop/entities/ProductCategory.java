package com.example.Myshop.entities;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "categories")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductCategory extends IdEntity {
	
	private String cname;

	@Override
	public String toString() {
		return "ProductCategory [cname=" + cname + "]";
	}

}