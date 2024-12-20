package com.example.Myshop.controller;

import com.example.Myshop.dto.OrderDto;
import com.example.Myshop.services.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping("/getallorders")
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        List<OrderDto> orderList = orderService.getAllOrders();
        return ResponseEntity.ok(orderList);
    }

    @GetMapping("/getorderdetails/{id}")
    public ResponseEntity<OrderDto> getOrderDetails(@PathVariable Long id) {
        Optional<OrderDto> orderFound = orderService.getOrderById(id);
        return orderFound.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/addorder")
    public ResponseEntity<OrderDto> addOrder(@RequestBody OrderDto orderDto) {
        OrderDto createdOrder = orderService.addOrder(orderDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdOrder);
    }

    @PutMapping("/updateorder/{id}")
    public ResponseEntity<OrderDto> updateOrder(@PathVariable Long id, @RequestBody OrderDto orderDto) {
        OrderDto updatedOrder = orderService.updateOrder(id, orderDto);
        return updatedOrder != null ? ResponseEntity.ok(updatedOrder)
                                    : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/deleteorder/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
