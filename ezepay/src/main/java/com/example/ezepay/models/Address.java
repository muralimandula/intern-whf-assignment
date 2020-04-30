package com.example.ezepay.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {   // phase 2 : Suggested to have a table separate table for address 
	@Id
	private Long transactionId;
	private String country;
	private String state;
	private String city;
	private String zip;
	private String iPAddress;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}
	public Address(Long transactionId, String country, String state, String city, String zip, String iPAddress) {
		super();
		this.transactionId = transactionId;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zip = zip;
		this.iPAddress = iPAddress;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getiPAddress() {
		return iPAddress;
	}
	public void setiPAddress(String iPAddress) {
		this.iPAddress = iPAddress;
	}
	
}
