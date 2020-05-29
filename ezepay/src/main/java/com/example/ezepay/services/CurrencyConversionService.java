package com.example.ezepay.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ezepay.models.CurrencyExchangeRateResponse;
import com.example.ezepay.models.Rates;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unchecked")
@RestController
public class CurrencyConversionService {
	
	@Autowired
	RestTemplate restTemplate;
	
	private static String exchangeRateUrl = "https://open.exchangerate-api.com/v6/latest";
	private Rates rates;
	
	@GetMapping("/conversionRates")
	public Rates getAllConversionRates() {
		
		if(this.rates == null) {
			CurrencyExchangeRateResponse currencyExchangeRateResponse = restTemplate.getForObject(exchangeRateUrl, CurrencyExchangeRateResponse.class);
			this.rates = currencyExchangeRateResponse.getRates(); 
		}
		return this.rates;
	}

	@GetMapping("/conversionRates/{currency}")
	public Double getConversionRateEndPoint(@PathVariable String currency) {

		if(this.rates == null) {
			CurrencyExchangeRateResponse currencyExchangeRateResponse = restTemplate.getForObject(exchangeRateUrl, CurrencyExchangeRateResponse.class);
			this.rates = currencyExchangeRateResponse.getRates(); 
		}
		Map<String, Object> rateConversionMap = new ObjectMapper().convertValue(this.rates, Map.class);
		
		return Double.valueOf(rateConversionMap.get(currency.toUpperCase()).toString());
	}
	
	public Double getConversionRate(String currency) {

		if(this.rates == null) {
			CurrencyExchangeRateResponse currencyExchangeRateResponse = restTemplate.getForObject(exchangeRateUrl, CurrencyExchangeRateResponse.class);
			this.rates = currencyExchangeRateResponse.getRates(); 
		}
		Map<String, Object> rateConversionMap = new ObjectMapper().convertValue(this.rates, Map.class);
		
		return Double.valueOf(rateConversionMap.get(currency.toUpperCase()).toString());
	}
}
