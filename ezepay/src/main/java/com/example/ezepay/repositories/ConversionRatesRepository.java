package com.example.ezepay.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.ezepay.models.ConversionRates;
import com.example.ezepay.models.Customer;

public interface ConversionRatesRepository extends CrudRepository<ConversionRates, Long>{

//	@Query("select :columnName from ConversionRates LIMIT 1")
//	Double findByColumnName(String columnName);
}
