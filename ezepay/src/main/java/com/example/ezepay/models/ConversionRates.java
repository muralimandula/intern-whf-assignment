package com.example.ezepay.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ConversionRates {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime dateTime;
	
	private Double AUD_CAD;
	private Double AUD_EUR;
	private Double AUD_INR;
	private Double AUD_USD;
	
	private Double CAD_AUD;
	private Double CAD_EUR;
	private Double CAD_INR;
	private Double CAD_USD;
	
	private Double EUR_AUD;
	private Double EUR_CAD;
	private Double EUR_INR;
	private Double EUR_USD;
	
	private Double INR_AUD;
	private Double INR_CAD;
	private Double INR_EUR;
	private Double INR_USD;
	
	private Double USD_INR;
	private Double USD_CAD;
	private Double USD_EUR;
	private Double USD_AUD;
	
	public ConversionRates() {
		// TODO Auto-generated constructor stub   
		// Below are conversion rates as on 7:20 PM 05/29/2020
		this.dateTime = java.time.LocalDateTime.now();
		this.AUD_CAD = 0.915792;
		this.AUD_EUR = 0.598168;
		this.AUD_INR = 50.319567;
		this.AUD_USD = 0.66606;
		this.CAD_AUD = 1.091951;
		this.CAD_EUR = 0.653171;
		this.CAD_INR = 54.946488;
		this.CAD_USD = 0.727305;
		this.EUR_AUD = 1.671305;
		this.EUR_CAD = 1.531032;
		this.EUR_INR = 84.13538;
		this.EUR_USD = 1.113498;
		this.INR_AUD = 0.019863;
		this.INR_CAD = 0.018149;
		this.INR_EUR = 0.011886;
		this.INR_USD = 0.013235;
		this.USD_INR = 75.565397;
		this.USD_CAD = 1.373465;
		this.USD_EUR = 0.89787;
		this.USD_AUD = 1.499925;
	}
	
	public ConversionRates(Double AUD_CAD, Double AUD_EUR, Double AUD_INR, Double AUD_USD,
			Double CAD_AUD, Double CAD_EUR, Double CAD_INR, Double CAD_USD, Double EUR_AUD, Double EUR_CAD,
			Double EUR_INR, Double EUR_USD, Double INR_AUD, Double INR_CAD, Double INR_EUR, Double INR_USD,
			Double USD_INR, Double USD_CAD, Double USD_EUR, Double USD_AUD) {
		super();
		this.dateTime = java.time.LocalDateTime.now();
		this.AUD_CAD = AUD_CAD;
		this.AUD_EUR = AUD_EUR;
		this.AUD_INR = AUD_INR;
		this.AUD_USD = AUD_USD;
		this.CAD_AUD = CAD_AUD;
		this.CAD_EUR = CAD_EUR;
		this.CAD_INR = CAD_INR;
		this.CAD_USD = CAD_USD;
		this.EUR_AUD = EUR_AUD;
		this.EUR_CAD = EUR_CAD;
		this.EUR_INR = EUR_INR;
		this.EUR_USD = EUR_USD;
		this.INR_AUD = INR_AUD;
		this.INR_CAD = INR_CAD;
		this.INR_EUR = INR_EUR;
		this.INR_USD = INR_USD;
		this.USD_INR = USD_INR;
		this.USD_CAD = USD_CAD;
		this.USD_EUR = USD_EUR;
		this.USD_AUD = USD_AUD;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
	public Double getAUD_CAD() {
		return AUD_CAD;
	}
	public void setAUD_CAD(Double aUD_CAD) {
		AUD_CAD = aUD_CAD;
	}
	public Double getAUD_EUR() {
		return AUD_EUR;
	}
	public void setAUD_EUR(Double aUD_EUR) {
		AUD_EUR = aUD_EUR;
	}
	public Double getAUD_INR() {
		return AUD_INR;
	}
	public void setAUD_INR(Double aUD_INR) {
		AUD_INR = aUD_INR;
	}
	public Double getAUD_USD() {
		return AUD_USD;
	}
	public void setAUD_USD(Double aUD_USD) {
		AUD_USD = aUD_USD;
	}
	public Double getCAD_AUD() {
		return CAD_AUD;
	}
	public void setCAD_AUD(Double cAD_AUD) {
		CAD_AUD = cAD_AUD;
	}
	public Double getCAD_EUR() {
		return CAD_EUR;
	}
	public void setCAD_EUR(Double cAD_EUR) {
		CAD_EUR = cAD_EUR;
	}
	public Double getCAD_INR() {
		return CAD_INR;
	}
	public void setCAD_INR(Double cAD_INR) {
		CAD_INR = cAD_INR;
	}
	public Double getCAD_USD() {
		return CAD_USD;
	}
	public void setCAD_USD(Double cAD_USD) {
		CAD_USD = cAD_USD;
	}
	public Double getEUR_AUD() {
		return EUR_AUD;
	}
	public void setEUR_AUD(Double eUR_AUD) {
		EUR_AUD = eUR_AUD;
	}
	public Double getEUR_CAD() {
		return EUR_CAD;
	}
	public void setEUR_CAD(Double eUR_CAD) {
		EUR_CAD = eUR_CAD;
	}
	public Double getEUR_INR() {
		return EUR_INR;
	}
	public void setEUR_INR(Double eUR_INR) {
		EUR_INR = eUR_INR;
	}
	public Double getEUR_USD() {
		return EUR_USD;
	}
	public void setEUR_USD(Double eUR_USD) {
		EUR_USD = eUR_USD;
	}
	public Double getINR_AUD() {
		return INR_AUD;
	}
	public void setINR_AUD(Double iNR_AUD) {
		INR_AUD = iNR_AUD;
	}
	public Double getINR_CAD() {
		return INR_CAD;
	}
	public void setINR_CAD(Double iNR_CAD) {
		INR_CAD = iNR_CAD;
	}
	public Double getINR_EUR() {
		return INR_EUR;
	}
	public void setINR_EUR(Double iNR_EUR) {
		INR_EUR = iNR_EUR;
	}
	public Double getINR_USD() {
		return INR_USD;
	}
	public void setINR_USD(Double iNR_USD) {
		INR_USD = iNR_USD;
	}
	public Double getUSD_INR() {
		return USD_INR;
	}
	public void setUSD_INR(Double uSD_INR) {
		USD_INR = uSD_INR;
	}
	public Double getUSD_CAD() {
		return USD_CAD;
	}
	public void setUSD_CAD(Double uSD_CAD) {
		USD_CAD = uSD_CAD;
	}
	public Double getUSD_EUR() {
		return USD_EUR;
	}
	public void setUSD_EUR(Double uSD_EUR) {
		USD_EUR = uSD_EUR;
	}
	public Double getUSD_AUD() {
		return USD_AUD;
	}
	public void setUSD_AUD(Double uSD_AUD) {
		USD_AUD = uSD_AUD;
	}
	
	
	
}
