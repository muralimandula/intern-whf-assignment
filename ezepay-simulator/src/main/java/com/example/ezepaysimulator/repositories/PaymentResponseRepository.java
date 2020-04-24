package com.example.ezepaysimulator.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ezepaysimulator.models.PaymentResponseBody;

@Repository
public interface PaymentResponseRepository extends CrudRepository<PaymentResponseBody, Long>{

}
