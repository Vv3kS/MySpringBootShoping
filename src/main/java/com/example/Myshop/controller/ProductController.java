package com.example.Myshop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Myshop.dto.ProductDto;
import com.example.Myshop.services.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	private ProductService productService ;
	
	@GetMapping("/all")
	public ResponseEntity<List<ProductDto>> getAllProducts(){
		List<ProductDto> productList = productService.getAllProducts() ;
		return ResponseEntity.ok(productList);
	} 
	
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
		ProductDto productByid = productService.getProductById(id);
		return ResponseEntity.ok(productByid);
	}
	
	@PostMapping("/createProduct")
	public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
		ProductDto create = productService.createProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(create);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProductDto> updateProduct(@PathVariable Long id , @RequestBody ProductDto productDto){
		ProductDto updatedProductDto = productService.updateProduct(id, productDto);
		return ResponseEntity.ok(updatedProductDto);
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
		productService.deleteProduct(id);
		return ResponseEntity.noContent().build();
				}

	@GetMapping("/category/{categoryId}")
	public ResponseEntity<List<ProductDto>>getProductsByCategory(@PathVariable Long categoryId){
		List<ProductDto> products = productService.getProductsByCategory(categoryId);
		return ResponseEntity.ok(products);
	}
	
}
