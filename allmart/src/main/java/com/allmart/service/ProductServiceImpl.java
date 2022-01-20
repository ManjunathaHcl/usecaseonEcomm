package com.allmart.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmart.dto.ProductDto;
import com.allmart.entity.Product;
import com.allmart.exception.InvalidProductInformation;
import com.allmart.repository.ProductRepository;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	public ModelMapper modelMapper;

	@Override
	public ProductDto addProduct(ProductDto ProductDto) {
		Product product = modelMapper.map(ProductDto, Product.class);
		product = productRepository.save(product);

		return modelMapper.map(product, ProductDto.class);

	}

	@Override
	public List<Product> getProductsByname(String productName) {
		// TODO Auto-generated method stub
		return productRepository.findByProductNameOrderByProductId(productName);
	}

	@Override
	public Product getProducts(Integer productId) {
		Optional<Product> product = productRepository.findById(productId);
		if (product.isPresent()) {
			return product.get();

		} else {
			throw new InvalidProductInformation();
		}
	}

}
