package com.example.Myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Myshop.entities.CartItemsEntity;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItemsEntity, Long>{
	

}
