package com.example.Myshop.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Myshop.dto.CartItemsDto;
import com.example.Myshop.entities.CartEntity;
import com.example.Myshop.entities.CartItemsEntity;
import com.example.Myshop.entities.Product;
import com.example.Myshop.repository.CartItemsRepository;
import com.example.Myshop.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	
	 @Autowired
	    private CartRepository cartRepository;
	    
	    @Autowired
	    private CartItemsRepository cartItemsRepository;

	@Override
	public ResponseEntity<CartItemsDto> addProductToCart(Long cartId, CartItemsDto cartItemsDto) {
		Optional<CartEntity> cart = cartRepository.findById(cartId);
        if (!cart.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        CartEntity cartEntity = cart.get();
        Product product = cartItemsDto.getProduct();
        CartItemsEntity cartItemsEntity = new CartItemsEntity();
        cartItemsEntity.setCart(cartEntity);
        cartItemsEntity.setProduct(product);
        cartItemsEntity.setQuantity(cartItemsDto.getQuantity());
        CartItemsEntity savedCartItem = cartItemsRepository.save(cartItemsEntity);
        CartItemsDto savedCartItemsDto = new CartItemsDto();
        savedCartItemsDto.setCart(savedCartItem.getCart());
        savedCartItemsDto.setProduct(savedCartItem.getProduct());
        savedCartItemsDto.setQuantity(savedCartItem.getQuantity());
        
        return ResponseEntity.ok(savedCartItemsDto);
	}

	@Override
	public ResponseEntity<CartItemsDto> updateCartItem(Long cartItemId, CartItemsDto cartItemsDto) {
        Optional<CartItemsEntity> existingItem = cartItemsRepository.findById(cartItemId);
        if (!existingItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        CartItemsEntity cartItemsEntity = existingItem.get();
        cartItemsEntity.setQuantity(cartItemsDto.getQuantity());
        CartItemsEntity updatedCartItem = cartItemsRepository.save(cartItemsEntity);
        CartItemsDto updatedCartItemsDto = new CartItemsDto();
        updatedCartItemsDto.setCart(updatedCartItem.getCart());
        updatedCartItemsDto.setProduct(updatedCartItem.getProduct());
        updatedCartItemsDto.setQuantity(updatedCartItem.getQuantity());
        return ResponseEntity.ok(updatedCartItemsDto);

        
		 
	}

	@Override
	public List<CartItemsDto> getCartItems(Long cartId) {
		 List<CartItemsEntity> cartItems = cartItemsRepository.findAll()
	                .stream()
	                .filter(item -> item.getCart().getId().equals(cartId))
	                .collect(Collectors.toList());
		 return cartItems.stream()
         .map(item -> new CartItemsDto(item.getProduct(), item.getCart(), item.getQuantity()))
         .collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<String> removeProductFromCart(Long cartItemId) {
        Optional<CartItemsEntity> cartItem = cartItemsRepository.findById(cartItemId);
        if (!cartItem.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        cartItemsRepository.deleteById(cartItemId);
        return ResponseEntity.ok("Product removed from cart");
	}

	@Override
	public Optional<CartItemsDto> getCartItem(Long cartItemId) {
        Optional<CartItemsEntity> cartItem = cartItemsRepository.findById(cartItemId);
        if (!cartItem.isPresent()) {
            return Optional.empty();
        }
        CartItemsEntity item = cartItem.get();
        CartItemsDto cartItemsDto = new CartItemsDto(item.getProduct(), item.getCart(), item.getQuantity());
        return Optional.of(cartItemsDto);
	}

}
