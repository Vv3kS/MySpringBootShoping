package com.example.Myshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Myshop.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
