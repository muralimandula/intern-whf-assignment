package com.example.ezepay.services;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.ezepay.models.Transaction;
import com.example.ezepay.repositories.TransactionRepository;


public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;  
	
	public void updateTransaction( ) {
		
	}
	
	
	public Iterable<Transaction> getAllTransactions() {
		
		return transactionRepository.findAll();
	}

}
