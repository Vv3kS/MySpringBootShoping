package com.example.Myshop.services;

import com.example.Myshop.dto.OrderDto;
import com.example.Myshop.entities.Order;
import com.example.Myshop.entities.Payment;
import com.example.Myshop.entities.Product;
import com.example.Myshop.entities.User;
import com.example.Myshop.repository.OrderRepository;
import com.example.Myshop.repository.PaymentRepository;
import com.example.Myshop.repository.ProductRepository;
import com.example.Myshop.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    private OrderDto convertToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setStatus(order.getStatus());
        orderDto.setPurchaseDate(order.getPurchaseDate());
        orderDto.setUser_Id(order.getUser().getId());
        orderDto.setProduct_id(order.getProduct().getId());
        orderDto.setPayment_id(order.getPayment().getId());
        return orderDto;
    }

    private Order convertToEntity(OrderDto orderDto) {
        User user = userRepository.findById(orderDto.getUser_Id())
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + orderDto.getUser_Id()));
        
        Product product = productRepository.findById(orderDto.getProduct_id())
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + orderDto.getProduct_id()));

        Payment payment = paymentRepository.findById(orderDto.getPayment_id())
                .orElseThrow(() -> new RuntimeException("Payment not found with ID: " + orderDto.getPayment_id()));

        return new Order(orderDto.getStatus(), user, product, payment, orderDto.getPurchaseDate());
    }

    @Override
    public List<OrderDto> getAllOrders() {
        return orderRepository.findAll().stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OrderDto> getOrderById(Long id) {
        return orderRepository.findById(id).map(this::convertToDto);
    }

    @Override
    public OrderDto addOrder(OrderDto orderDto) {
        Order order = convertToEntity(orderDto);
        Order savedOrder = orderRepository.save(order);
        return convertToDto(savedOrder);
    }

    @Override
    public OrderDto updateOrder(Long id, OrderDto orderDto) {
        Optional<Order> existOrder = orderRepository.findById(id);

        if (existOrder.isPresent()) {
            Order existingOrder = existOrder.get();
            existingOrder.setStatus(orderDto.getStatus());
            existingOrder.setPurchaseDate(orderDto.getPurchaseDate());

            User user = new User();
            user.setId(orderDto.getUser_Id());
            existingOrder.setUser(user);

            Product product = new Product();
            product.setId(orderDto.getProduct_id());
            existingOrder.setProduct(product);

            Payment payment = new Payment();
            payment.setId(orderDto.getPayment_id());
            existingOrder.setPayment(payment);

            Order updatedOrder = orderRepository.save(existingOrder);
            return convertToDto(updatedOrder);
        } else {
            return null;
        }
    }

    @Override
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}
