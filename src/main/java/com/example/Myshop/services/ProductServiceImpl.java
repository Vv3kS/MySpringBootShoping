package com.example.Myshop.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Myshop.dto.ProductDto;
import com.example.Myshop.entities.Product;
import com.example.Myshop.entities.ProductCategory;
import com.example.Myshop.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	

	@Autowired
	private ProductRepository productRepository;
	
	 private ProductDto convertToDto(Product product) {
	        ProductDto productDto = new ProductDto();
	        productDto.setId(product.getId());
	        productDto.setP_name(product.getP_name());
	        productDto.setP_Description(product.getP_Description());
	        productDto.setPrice(product.getPrice());
	        productDto.setStocks(product.getStocks());
	        if (product.getCategory() != null) {
	            productDto.setCategory_id(product.getCategory().getId());
	        }
	        return productDto;
	    }
	
	
	 private Product convertToEntity(ProductDto productDto) {
	        Product product = new Product();
	        product.setP_name(productDto.getP_name());
	        product.setP_Description(productDto.getP_Description());
	        product.setPrice(productDto.getPrice());
	        product.setStocks(productDto.getStocks());
	        ProductCategory category = new ProductCategory();
	        category.setId(productDto.getCategory_id());  
	        product.setCategory(category);
	        return product;
	    }
	
	@Override
	public List<ProductDto> getAllProducts() {
		List<Product> product = productRepository.findAll();
		return product.stream()
		.map(this::convertToDto)
		.collect(Collectors.toList());
			
	}

	@Override
	public ProductDto getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("product Not Available"));
		return convertToDto(product);
	}

	@Override
	public ProductDto createProduct(ProductDto productDto) {
		 Product product = convertToEntity(productDto);
		 product = productRepository.save(product);
		 
		return convertToDto(product);
	}

	@Override
	public ProductDto updateProduct(Long id, ProductDto productDto) {
		 Product product = productRepository.findById(id)
	                .orElseThrow(() -> new EntityNotFoundException("Product not found with id: " + id));
	        product.setP_name(productDto.getP_name());
	        product.setP_Description(productDto.getP_Description());
	        product.setPrice(productDto.getPrice());
	        product.setStocks(productDto.getStocks());
	        ProductCategory category = new ProductCategory();
	        category.setId(productDto.getCategory_id());
	        product.setCategory(category);
	        product = productRepository.save(product);
	        return convertToDto(product);
	    }

	@Override
	public void deleteProduct(Long id) {
		Product product = productRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The product you are trying to found is not available"));
		productRepository.delete(product);
		
		
	}


	@Override
	public List<ProductDto> getProductsByCategory(Long categoryId) {
		List<Product>products=productRepository.findByCategoryId(categoryId);
		return products.stream()  
				.map(this::convertToDto).collect(Collectors.toList());
				
	} 
	
	
}
