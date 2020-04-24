package com.example.ezepay.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.ezepay.models.PaymentRequestBody;

public interface PaymentRequestRepository extends CrudRepository<PaymentRequestBody, Long>{

}
