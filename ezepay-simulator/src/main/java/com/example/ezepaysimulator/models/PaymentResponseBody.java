package com.example.ezepaysimulator.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentResponseBody {
	
	@Id
	private Long referenceId;

	private int errorCode;
	
	private String status;

	private String message;
	
	public PaymentResponseBody() {
		// TODO Auto-generated constructor stub
	}
	
	public PaymentResponseBody(Long refId) {
		this.referenceId = refId;
	}

	public PaymentResponseBody(Long referenceId, int errorCode, String status, String message) {
		super();
		this.referenceId = referenceId;
		this.errorCode = errorCode;
		this.status = status;
		this.message = message;
	}

	@Override
	public String toString() {
		return "PaymentResponseBody [referenceId=" + referenceId + ", errorCode=" + errorCode + ", status=" + status
				+ ", message=" + message + "]";
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
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
