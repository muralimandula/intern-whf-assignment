package com.example.ezepaysimulator.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.ezepaysimulator.models.PaymentRequestBody;

public interface PaymentRequestRepository extends CrudRepository<PaymentRequestBody, Long> {

}
