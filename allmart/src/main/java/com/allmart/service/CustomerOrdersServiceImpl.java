package com.allmart.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allmart.entity.Orders;
import com.allmart.repository.OrdersRepository;

@Service
public class CustomerOrdersServiceImpl implements CustomerOrdersService {

	@Autowired
	private OrdersRepository ordersRepository;

	@Override
	public List<Orders> getOrdersByCustId(Integer custId) {
		// TODO Auto-generated method stub

		Optional<List<Orders>> listorder = ordersRepository.findByCustomerId(custId);

		return listorder.get();
	}

}
