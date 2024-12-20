package com.example.Myshop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Myshop.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	 List<Product> findByCategoryId(Long categoryId);
}
