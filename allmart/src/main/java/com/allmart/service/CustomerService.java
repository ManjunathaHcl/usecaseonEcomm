package com.allmart.service;

import com.allmart.dto.CustomerDto;
import com.allmart.entity.Customer;

public interface CustomerService {
	
	Customer addCustomer(CustomerDto customerDto);

	Customer getcustomer(Long customerId );

	
}
