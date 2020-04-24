package com.example.ezepay.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.ezepay.models.PaymentResponseBody;

public interface PaymentResponseRepository extends CrudRepository<PaymentResponseBody, Long>{

}
