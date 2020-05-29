package com.example.ezepay.services;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ezepay.controllers.MainController;
import com.example.ezepay.models.ConversionRates;
import com.example.ezepay.models.CurrencyConversionResponse;
import com.example.ezepay.models.CurrencyExchangeRateResponse;
import com.example.ezepay.models.Rates;
import com.example.ezepay.repositories.ConversionRatesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SuppressWarnings("unchecked")
@RestController
@Service
public class CurrencyConversionService {
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	ConversionRatesRepository conversionRatesRepository;
	
	private static final Logger log = LoggerFactory.getLogger(CurrencyConversionService.class);
	
	private static String exchangeRateUrl = "https://open.exchangerate-api.com/v6/latest";
	private Rates rates;
	
	
	private String urlPre = "https://free.currconv.com/api/v7/convert?q=";
	private String  urlPost = "&compact=ultra&apiKey=";
	private static String currencyConverterApiKey = "446a19bec57ee7b70d4a";
	
	private static String[] conversionsArr = {"AUD_CAD",
														"AUD_EUR",
														"AUD_INR",
														"AUD_USD",
														"CAD_AUD",
														"CAD_EUR",
														"CAD_INR",
														"CAD_USD",
														
														"EUR_AUD",
														"EUR_CAD",
														"EUR_INR",
														"EUR_USD",
														
														"INR_AUD",
														"INR_CAD",
														"INR_EUR",
														"INR_USD",
														
														"USD_INR",
														"USD_CAD",
														"USD_EUR",
														"USD_AUD"};
	
	

//	
//	@PostConstruct         	          // Enables method to run as soon as the class (@Service here) constructed/created
//    @Scheduled(cron = "* * 1 * * *")  // schedule = "second minute hour day month year"), keep running the method as scheduled.. Every 1st minute of hour
	
	@GetMapping("/cc")
    public Object fetchConversionRate() throws IOException, InterruptedException {

//		HashMap<String,Double> currencyMap = new HashMap<String, Double>();
//		ConversionRates conversionRatesObject = new ConversionRates();
		
//		Map<String, Object> rateConversionMap = new ObjectMapper().convertValue(conversionRatesObject, Map.class);
		
//		for (String eachConversion : conversionsArr) {
//			
//			HashMap<String,Double> conversionRate =(HashMap<String,Double>) restTemplate.getForObject(urlPre + eachConversion + urlPost + currencyConverterApiKey, Object.class); 
//			currencyMap.put(eachConversion, conversionRate.get(eachConversion));
//			
//		}
		
//		ConversionRates conversionRatesObject = new ObjectMapper().convertValue(currencyMap, ConversionRates.class);
		
//		conversionRatesRepository.save(conversionRatesObject);  /// Static entry of all rates happened
		return conversionRatesRepository.findById((long) 1);
	}
	
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
	
	public Double getConversionRate(String fromCurrency, String toCurrency) {
		
		// Works on written query
//		return conversionRatesRepository.findByColumnName((fromCurrency + "_" + toCurrency).toLowerCase());
		
		log.info( "--------------" + fromCurrency + " " + toCurrency);
		ConversionRates conversionRatesObject = conversionRatesRepository.findById((long) 1).get();
		
		Map<String, Object> rateConversionMap = new ObjectMapper().convertValue(conversionRatesObject, Map.class); // aud_EUR=0.598168, aud_INR=50.319567, aud_USD=0.66606, cad_EUR=0.653171,
		
		log.info(rateConversionMap.toString());
		log.info(fromCurrency.toLowerCase() + "_" + (toCurrency).toUpperCase());
		
		Double conversionRateDouble = Double.valueOf(rateConversionMap.get(fromCurrency.toLowerCase() + "_" + toCurrency.toUpperCase()).toString());
		
		log.info(conversionRateDouble + "----------->>>>>>>>>>");
		return conversionRateDouble;
	}
	
	public int getFinalAmount(int amount, Double conversionRate) {
		
		return (int) (amount * conversionRate);
	}
}
