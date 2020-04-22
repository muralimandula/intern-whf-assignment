package com.example.ezepay.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.ezepay.models.Transaction;

public interface TransactionRepository extends CrudRepository<Transaction, Long>{

}
