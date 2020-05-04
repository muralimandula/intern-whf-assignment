package com.example.ezepay.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long customerId;
	
	private String email;
	private String firstName;
	private String lastName;
	private String contact;
	private String dOB;
	private String status; //Phase 2
	
//	public ArrayList<Integer> savedCards;
//	public ArrayList<Integer> transactions;
	
	protected Customer() {
		// TODO Auto-generated constructor stub : PROTECTED
	}


	// Liquibase, Openfiegn...

	public Customer(String firstName, String lastName, String email, String contact, String dOB) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.contact = contact;
		this.dOB = dOB;
		this.status = "Whitelist";  // phase 2
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
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
	public String getDOB() {
		return this.dOB;
	}
	public void setDOB(String dOB) {
		this.dOB = dOB;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
