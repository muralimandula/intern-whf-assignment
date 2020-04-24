package com.example.ezepay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.example.ezepay.models.PaymentRequestBody;
import com.example.ezepay.models.PaymentResponseBody;

public class AuthenticationService {

	@Autowired
	RestTemplate restTemplate;
	
	public PaymentResponseBody getAuthentication(PaymentRequestBody requestBody) {
		
		/*
		 *  Here is where we have to make a request to the simulator for the authentication to be done.
		 *  Status of the transaction will be done here.
		 *  
		 */
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    
	    HttpEntity<?> entity = new HttpEntity<Object>(requestBody,headers);
	    
	    /**
	     * Parameters:
	     * 	url    : the URL
	     * 	method : the HTTP method (GET, POST, etc)
	     * 	requestEntity  : the entity (headers and/or body) to write to the requestmay be null)
	     * 	responseType   : the type of the return value
	     * 	uriVariables   : the variables to expand in the template
	     * 
	     * Returns:
	     * 	 the response as entity
	     */
	    ResponseEntity<PaymentResponseBody> responseEntity =    restTemplate.exchange("http://localhost:8081/authentication", 
	    															HttpMethod.POST,
	    															entity,
	    															PaymentResponseBody.class);
	    
	    return responseEntity.getBody();
	}
}
