package com.allmart.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allmart.dto.CartDetailsDto;
import com.allmart.dto.CheckOutSummaryDto;
import com.allmart.dto.ProductDto;
import com.allmart.service.ProductBuyService;

@RestController
public class ProductBuyController {
	@Autowired
	private ProductBuyService productBuyServiceImpl;
	
	@PostMapping("/checkOut")
	public CheckOutSummaryDto checkOut(@RequestBody  CartDetailsDto cartDetails) {
		
		return productBuyServiceImpl.checkOut(cartDetails);

	}

	
	
}
