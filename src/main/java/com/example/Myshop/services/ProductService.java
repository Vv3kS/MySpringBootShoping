package com.example.Myshop.services;

import java.util.List;

import com.example.Myshop.dto.ProductDto;

public interface ProductService {
	
	  List<ProductDto> getAllProducts();
	  
	  ProductDto getProductById(Long id);
	  
	  ProductDto createProduct(ProductDto productDto);
	  
	  ProductDto updateProduct(Long id, ProductDto productDto);
	  
	  void deleteProduct(Long id);

	List<ProductDto> getProductsByCategory(Long categoryId);

}
