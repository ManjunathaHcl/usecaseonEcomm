package com.allmart.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.allmart.dto.CustomerDto;
import com.allmart.entity.Customer;
import com.allmart.service.CustomerServiceImpl;

import io.swagger.annotations.ApiOperation;

@RestController
public class CustomerController {

	@Autowired
	private CustomerServiceImpl customerServiceImpl;


	@PostMapping("/register")
	@ApiOperation(value = "To register Customer with the Bank")
	public Customer customerRegistration(@Valid @RequestBody CustomerDto customerDto) {
		return customerServiceImpl.addCustomer(customerDto);
		
	}
	
	@GetMapping("/customer/{custid}")
	@ApiOperation(value = "To get the Customer ")
	public Customer getCustomer(@PathVariable Long custid) {
		return customerServiceImpl.getcustomer(custid);
		
	}
	
}
