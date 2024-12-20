package com.example.Myshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.example.Myshop.dto.CartItemsDto;

public interface CartService {

    ResponseEntity<CartItemsDto> addProductToCart(Long cartId, CartItemsDto cartItemsDto);
    
    ResponseEntity<CartItemsDto> updateCartItem(Long cartItemId, CartItemsDto cartItemsDto);

    List<CartItemsDto> getCartItems(Long cartId);

    ResponseEntity<String> removeProductFromCart(Long cartItemId);

    Optional<CartItemsDto> getCartItem(Long cartItemId);

}
