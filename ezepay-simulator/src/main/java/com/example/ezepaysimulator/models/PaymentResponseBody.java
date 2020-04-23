package com.example.ezepaysimulator.models;

public class PaymentResponseBody {
	
	private Long referenceId;

	private int errorCode;
	
	private String message;
	
	public PaymentResponseBody() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentResponseBody(Long refId) {
		this.referenceId = refId;
	}
	
	public PaymentResponseBody(Long refIdLong, int i, String string) {
		// TODO Auto-generated constructor stub
		this.referenceId = refIdLong;
		this.errorCode = i;
		this.message = string;
	}
	
	public Long getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(Long referenceId) {
		this.referenceId = referenceId;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
