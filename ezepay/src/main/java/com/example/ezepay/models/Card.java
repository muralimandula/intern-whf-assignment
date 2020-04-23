package com.example.ezepay.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//1.	Check in our database for the card details and create if not exist and these details should be saved against transaction.
//2.	Do not save cvv, expiry details and complete card number only first 6 digits (Call it as cardbin) and last 4 digits (Call it as cardnum).

@Entity
public class Card {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cardId;
	
	private int cardBin;
	private int cardNum;
//	private int expiryYear;
//	private int expiryMonth;
	private String cardHolderName;
	private String issuer;
	
	protected Card() {
		// TODO Auto-generated constructor stub  : PROTECTED
	}
	
	public Card(int cardBin, int cardNum, int expiryYear, int expiryMonth, String cardHolderName, String issuer) {
		super();
		this.cardBin = cardBin;
		this.cardNum = cardNum;
//		this.expiryYear = expiryYear;
//		this.expiryMonth = expiryMonth;
		this.cardHolderName = cardHolderName;
		this.issuer = issuer;
	}

	public Long getCardId() {
		return cardId;
	}
	public void setCardId(Long cardId) {
		this.cardId = cardId;
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
//	public int getExpiryYear() {
//		return expiryYear;
//	}
//	public void setExpiryYear(int expiryYear) {
//		this.expiryYear = expiryYear;
//	}
//	public int getExpiryMonth() {
//		return expiryMonth;
//	}
//	public void setExpiryMonth(int expiryMonth) {
//		this.expiryMonth = expiryMonth;
//	}
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
