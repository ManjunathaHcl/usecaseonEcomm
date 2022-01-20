package com.allmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allmart.dto.ProductDto;
import com.allmart.entity.Product;
import com.allmart.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;

	@PostMapping("/products")
	public ProductDto addProduct(@RequestBody ProductDto productDto) {
		productService.addProduct(productDto);
		return productDto;

	}

	@GetMapping("/products/{productId}")
	public Product ProductgetProducts(@PathVariable Integer productId) {
		return productService.getProducts(productId);

	}
  
	
	@GetMapping("/product/{productName}")
	public List<Product> getProductsByName(@PathVariable String productName) {
		return productService.getProductsByname(productName);

	}
}
