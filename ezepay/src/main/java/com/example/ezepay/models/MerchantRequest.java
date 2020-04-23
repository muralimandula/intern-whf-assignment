package com.example.ezepay.models;

import java.net.InetAddress;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.ezepay.controllers.MainController;

@Entity
public class MerchantRequest {
	
	private static final Logger log = LoggerFactory.getLogger(MainController.class);
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long requestId;
	

	//--------------------------Customer Info
	private String email;
	private String firstName;
	private String lastName;
	private String contact;
	private String country;
	private String zip;
	private String state;
	private String city;
	private String iPAddress;
	private String dOB;
	
	private int amount;
	private String currency;
	
	private int cardBin;
	private int cardNum;
	private int expiryYear;
	private int expiryMonth;
	private String cardHolderName;
	private String issuer;

	public MerchantRequest() {
		// TODO Auto-generated constructor stub
	}
	public MerchantRequest(String email, String firstName, String lastName, String contact, String country, String zip,
			String state, String city, String dOB, int amount, String currency, int cardBin,
			int cardNum, int expiryYear, int expiryMonth, String cardHolderName, String issuer) {
		super();
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contact = contact;
		this.country = country;
		this.zip = zip;
		this.state = state;
		this.city = city;
		
		try {
			InetAddress localhost = InetAddress.getLocalHost(); 
//	        System.out.println("System IP Address : " + (localhost.getHostAddress()).trim()); 
			log.info("---------Customer from IP Address : " + (localhost.getHostAddress()).trim());
			this.iPAddress = localhost.getHostAddress().trim();

		}catch (Exception e) {
			// TODO: handle exception
			this.iPAddress = e.toString();
		}

		this.dOB = dOB;
		this.amount = amount;
		this.currency = currency;
		this.cardBin = cardBin;
		this.cardNum = cardNum;
		this.expiryYear = expiryYear;
		this.expiryMonth = expiryMonth;
		this.cardHolderName = cardHolderName;
		this.issuer = issuer;
	}
	
	public Long getRequestId() {
		return requestId;
	}
	public void setRequestId(Long requestId) {
		this.requestId = requestId;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
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
	public String getiPAddress() {
		return iPAddress;
	}
	public void setiPAddress(String iPAddress) {
		this.iPAddress = iPAddress;
	}
	public String getDOB() {
		return this.dOB;
	}
	public void setDOB(String dOB) {
		this.dOB = dOB;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public int getCardBin() {
		return cardBin;
	}
	public void setCardBin(int cardBin) {
		this.cardBin = cardBin;
	}
	public int getCardNum() {
		return cardNum;
	}
	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}
	public int getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(int expiryYear) {
		this.expiryYear = expiryYear;
	}
	public int getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(int expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	public String getIssuer() {
		return issuer;
	}
	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

}
