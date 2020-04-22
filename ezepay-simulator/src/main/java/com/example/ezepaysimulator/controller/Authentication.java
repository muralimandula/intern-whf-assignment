package com.example.ezepaysimulator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ezepaysimulator.models.PaymentResponseBody;
import com.example.ezepaysimulator.repositories.PaymentRequestRepository;
import com.example.ezepaysimulator.models.PaymentRequestBody;

@Controller
public class Authentication {
	
	
	private static final Logger log = LoggerFactory.getLogger(Authentication.class);

	@Autowired
	PaymentRequestRepository paymentRequestRepository;
	
	@PostMapping("/authentication")
	public ResponseEntity<PaymentResponseBody> doAuthenticationEntity(@RequestBody PaymentRequestBody paymentRequestBody) {
		
		log.info("----- Payment request made by " + paymentRequestBody.getCustomerName());
		
		Long refIdLong = paymentRequestRepository.save(paymentRequestBody).getReferenceId();
		
		PaymentResponseBody responseBody = new PaymentResponseBody(refIdLong, 200, "SUCCESS");
		
		return ResponseEntity.ok(responseBody);
	}
}
