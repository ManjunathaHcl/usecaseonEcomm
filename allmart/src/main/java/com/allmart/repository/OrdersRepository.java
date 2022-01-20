package com.allmart.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allmart.entity.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {

	
	Optional<List<Orders>> findByCustomerId(Integer customerId);
}
