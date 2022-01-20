package com.allmart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.allmart.entity.Orders;
import com.allmart.service.CustomerOrdersServiceImpl;

@RestController
public class CustomerOrders {
	@Autowired
	private CustomerOrdersServiceImpl CustomerOrdersService;

	@GetMapping("/orders/{customerId}")
	private List<Orders> getOrders(@PathVariable Integer customerId) {
		return CustomerOrdersService.getOrdersByCustId(customerId);

	}

}
