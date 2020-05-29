package com.example.ezepay.models;

import java.util.HashMap;

public class CurrencyConversionResponse {
	
	private HashMap<String, Double> conversionRate;
	
	
	public CurrencyConversionResponse(HashMap<String, Double> hmap) {
		super();

		this.conversionRate = hmap;
//		this.conversionRate.put(conversion, conversionRate);
	}
	
	public HashMap<String, Double> getConversionRate() {
		return conversionRate;
	}
	public void setConversionRate(HashMap<String, Double> conversionRate) {
		this.conversionRate = conversionRate;
	}
	
	
}
