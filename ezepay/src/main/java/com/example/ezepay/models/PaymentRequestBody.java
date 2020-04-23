package com.example.ezepay.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentRequestBody {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long referenceId;
	
	private Long gatewayId;
	private int cardBin;
	private int cardNum;
	
	private int amount;
	private String customerName;
	private String customerContact;
	
	public PaymentRequestBody() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentRequestBody(Long gatewayId, int cardBin, int cardNum, int amount, String customerName, String customerContact) {
		super();
		this.gatewayId = gatewayId;
		this.cardBin = cardBin;
		this.cardNum = cardNum;
		this.amount = amount;
		this.customerName = customerName;
		this.customerContact = customerContact;
	}

	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public Long getGatewayId() {
		return gatewayId;
	}

	public void setGatewayId(Long gatewayId) {
		this.gatewayId = gatewayId;
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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}
	
	
	
}
