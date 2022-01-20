package com.allmart.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmart.dto.CustomerDto;
import com.allmart.entity.Customer;
import com.allmart.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	public ModelMapper modelMapper;

	@Override
	public Customer addCustomer(CustomerDto customerDto) {
		// TODO Auto-generated method sreturn null;tub

		Customer customer = modelMapper.map(customerDto, Customer.class);
		customer = customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer getcustomer(Long customerId) {
		// TODO Auto-generated method stub

		Optional<Customer> cust = customerRepository.findById(customerId);

		return cust.get();
	}

}
