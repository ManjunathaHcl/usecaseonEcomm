package com.allmart.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.allmart.entity.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>   {
	
    
}
