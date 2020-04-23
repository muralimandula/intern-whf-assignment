package com.example.ezepay.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


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
	
	private Long customerId;
	private Long cardId;

	private int amount;
	private String currency;

    private Date date;
    
    private Long referenceId;
	
	protected Transaction() {
		// TODO Auto-generated constructor stub
	}


	public Transaction(String status, Long merchantRequestId, Long merchantId, Long customerId,
			Long cardId, int amount, String currency) {
		super();
		this.status = status;
		this.merchantRequestId = merchantRequestId;
		this.merchantId = merchantId;
		this.customerId = customerId;
		this.cardId = cardId;
		this.amount = amount;
		this.currency = currency;
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

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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



}
