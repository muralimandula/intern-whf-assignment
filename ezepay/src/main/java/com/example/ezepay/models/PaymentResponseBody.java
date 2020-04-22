package com.example.ezepay.models;

public class PaymentResponseBody {
	

	private Long referenceId;

	private int errorCode;
	
	private String message;
	
	public PaymentResponseBody() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "PaymentResponseBody [referenceId=" + referenceId + ", errorCode=" + errorCode + ", message=" + message
				+ "]";
	}


	public PaymentResponseBody(Long referenceId, int errorCode, String message) {
		super();
		this.referenceId = referenceId;
		this.errorCode = errorCode;
		this.message = message;
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
