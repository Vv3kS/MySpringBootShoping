package com.example.Myshop.services;

import java.util.List;
import java.util.Optional;

import com.example.Myshop.dto.OrderDto;

public interface OrderService {

	List<OrderDto>getAllOrders();
	
	 Optional<OrderDto> getOrderById(Long id);
	 
	 OrderDto addOrder(OrderDto orderDto);
	 
	 OrderDto updateOrder(Long id, OrderDto orderDto);
	 
	 void deleteOrder(Long id);
}
