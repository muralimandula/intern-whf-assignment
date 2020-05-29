package com.example.ezepay.models;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


//Operations on transactions:
//1.	Maintain below transaction statuses on our end
//a.	Pending
//b.	Completed
//c.	Blocked
//d.	Failed
//e.	Charge back
//f.	Refund
//g.	Abandoned
//2.	Should be able to change the transaction status

//3.	Transaction details
//a.	Amount
//b.	Currency


@Entity
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long transactionId;

	private String status;
	
	private Long merchantRequestId;

	private Long merchantId;
	private String merchantName; //Phase 2

	private Long customerId;
	private String customerName;  //Phase 2
	private String customerContact; //Phase 2
	
	private Long cardId;

	private int amount;
	private String currency;

    private Date date;
    
    @CreationTimestamp
    private LocalDateTime createdAt; //Phase 2
    @UpdateTimestamp
    private LocalDateTime updatedAt; //Phase 2
    
    private Long referenceId; //Phase 2
    
	private String toCurrency; //Post review
    
    private Double conversionRate; //Post review
    
    private int finalAmount; //Post review
    
	
	protected Transaction() {
		// TODO Auto-generated constructor stub
	}


	public Transaction(String status, Long merchantRequestId,
										Long merchantId,
										String merchantName,  // phase 2
										Long customerId,
										String customerName,  // phase 2
										String customerContact,  // phase 2
										Long cardId, int amount, String currency,
										String toCurrency, Double conversionRate, Integer finalAmount) {  //Post review
		super();
		this.status = status;
		this.merchantRequestId = merchantRequestId;
		this.merchantId = merchantId;
		this.merchantName = merchantName;  // phase 2
		this.customerId = customerId;
		this.customerName = customerName;  // phase 2
		this.customerContact = customerContact;  // phase 2
		this.cardId = cardId;
		this.amount = amount;
		this.currency = currency;
		this.toCurrency = toCurrency;
		this.conversionRate = conversionRate;
		this.finalAmount = finalAmount;
		this.date = java.util.Calendar.getInstance().getTime();
	}


//	public String[] statusArray= {"Pending", "Completed", "Blocked", "Failed", "Chargeback", "Refund", "Abandoned"};
	public Long getTransactionId() {
		return transactionId;
	}


	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Long getMerchantRequestId() {
		return merchantRequestId;
	}

	public void setMerchantRequestId(Long merchantRequestId) {
		this.merchantRequestId = merchantRequestId;
	}

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public String getMerchantName() {
		return merchantName;
	}


	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	public Long getCardId() {
		return cardId;
	}

	public void setCardId(Long cardId) {
		this.cardId = cardId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public Long getReferenceId() {
		return referenceId;
	}


	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

    public String getToCurrency() {
		return toCurrency;
	}


	public void setToCurrency(String toCurrency) {
		this.toCurrency = toCurrency;
	}


	public Double getConversionRate() {
		return conversionRate;
	}


	public void setConversionRate(Double conversionRate) {
		this.conversionRate = conversionRate;
	}


	public int getFinalAmount() {
		return finalAmount;
	}


	public void setFinalAmount(int finalAmount) {
		this.finalAmount = finalAmount;
	}



}
