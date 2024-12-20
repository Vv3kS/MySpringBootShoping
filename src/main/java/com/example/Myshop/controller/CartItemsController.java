package com.example.Myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myshop.dto.CartItemsDto;
import com.example.Myshop.services.CartService;

@RestController
@RequestMapping("/cart")
public class CartItemsController {

	@Autowired
	private CartService cartService ;
	
	@PostMapping("/{cartId}/add")
	public ResponseEntity<CartItemsDto> addProductToCart(@PathVariable Long cartId , @RequestBody CartItemsDto cartItemsDto){
		return cartService.addProductToCart(cartId, cartItemsDto);
	}
	
	@GetMapping("/{cartId}/items")
	public List<CartItemsDto> getCartItems(@PathVariable Long cartId) {
	    return cartService.getCartItems(cartId);
	    }
	@DeleteMapping("/remove/{cartItemId}")
    public ResponseEntity<String> removeProductFromCart(@PathVariable Long cartItemId) {
        return cartService.removeProductFromCart(cartItemId);
    }
	
	@GetMapping("/item/{cartItemId}")
    public ResponseEntity<CartItemsDto> getCartItem(@PathVariable Long cartItemId) {
        return cartService.getCartItem(cartItemId)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
	  
}
