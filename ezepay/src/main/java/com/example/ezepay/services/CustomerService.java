package com.example.ezepay.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.ezepay.models.Customer;
import com.example.ezepay.models.MerchantRequest;
import com.example.ezepay.repositories.CustomerRepository;


public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;
	
	public Iterable<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	
	public Customer findAndUpdateCustomer(MerchantRequest merchantRequest) {
		
		
		final Logger log = LoggerFactory.getLogger(CustomerService.class);
		
		Customer currentCustomer = customerRepository.findByEmail(merchantRequest.getEmail());
		Long currentCustomerId;


		if(currentCustomer == null) {
			// -----------------------------------------------------------------------------------------------Creating a new Customer entry, when NOT FOUND IN DATABASE
			
			currentCustomer = new Customer(merchantRequest.getEmail(),
											merchantRequest.getFirstName(),
											merchantRequest.getLastName(),
											merchantRequest.getContact(), 
											merchantRequest.getCountry(),
											merchantRequest.getZip(),
											merchantRequest.getState(),
											merchantRequest.getCity(),
											merchantRequest.getiPAddress(),
											merchantRequest.getDOB());
			
			currentCustomer = customerRepository.save(currentCustomer); // Saves and return Customer object updated with id.
			currentCustomerId = currentCustomer.getCustomerId(); 		// To get update auto-generated Id in Database.
			
			log.info("--------------NEW CUSTOMER entry with id : " + currentCustomerId);

		} else {
			currentCustomerId = currentCustomer.getCustomerId();
			log.info("--------------Customer FOUND!!  id : " + currentCustomerId + " , name : " + currentCustomer.getFirstName() + " " + currentCustomer.getLastName());
		}
		
		return currentCustomer;
		
	}
}
