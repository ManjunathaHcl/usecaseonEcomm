package com.allmart.service;


import java.util.List;

import com.allmart.entity.Orders;
public interface CustomerOrdersService {
	List<Orders> getOrdersByCustId(Integer custId);
	
	

}
