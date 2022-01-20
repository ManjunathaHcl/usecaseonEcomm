package com.allmart.service;

import java.util.List;

import com.allmart.dto.ProductDto;
import com.allmart.entity.Product;

public interface ProductService {
	ProductDto addProduct(ProductDto ProductDto);
	Product getProducts(Integer productId);
	List<Product> getProductsByname(String productName);
	
}
