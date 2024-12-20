package com.example.Myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Myshop.entities.CartEntity;

@Repository
public interface CartRepository extends JpaRepository<CartEntity, Long> {

}
