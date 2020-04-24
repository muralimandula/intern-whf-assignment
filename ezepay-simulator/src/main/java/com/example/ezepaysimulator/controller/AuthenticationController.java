package com.example.ezepaysimulator.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.ezepaysimulator.models.PaymentResponseBody;
import com.example.ezepaysimulator.repositories.DummyRepository;
import com.example.ezepaysimulator.repositories.PaymentRequestRepository;
import com.example.ezepaysimulator.repositories.PaymentResponseRepository;
import com.example.ezepaysimulator.models.PaymentRequestBody;

@Controller
public class AuthenticationController {
	
	
	private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	PaymentRequestRepository paymentRequestRepository;
	
	@Autowired
	PaymentResponseRepository paymentResponseRepository;
	
	@Autowired
	DummyRepository dummyRepository;
	
	@PostMapping("/authentication")
	public ResponseEntity<PaymentResponseBody> doAuthenticationEntity(@RequestBody PaymentRequestBody paymentRequestBody) {
		
		log.info("----- Payment request made by " + paymentRequestBody.getCustomerName());
		
		
		Long refIdLong = paymentRequestRepository.save(paymentRequestBody).getReferenceId();
//		dummyRepository.save(new DummyModel());
		PaymentResponseBody responseBody = new PaymentResponseBody(refIdLong);
		
		int paymentAmount = paymentRequestBody.getAmount();
		
		if (paymentAmount < 50) {
			responseBody.setErrorCode(101);
			responseBody.setStatus("FAILED");
			responseBody.setMessage("Transaction amount must be 50  or above.");
		} else if (paymentAmount > 10000) {
			responseBody.setErrorCode(201);
			responseBody.setStatus("FAILED");
			responseBody.setMessage("Transaction amount above 10000 cannot be processed now.");
		}else {
			responseBody.setErrorCode(200);
			responseBody.setStatus("SUCCESS");
			responseBody.setMessage("Transaction successful.");	
		}
		
		paymentResponseRepository.save(responseBody);
		
		return ResponseEntity.ok(responseBody);

	}
}
