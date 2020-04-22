package com.example.ezepay.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.ezepay.models.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

	
	@Query("select c from Customer c where c.email = :email")
	Customer findByEmail(String email);
}
