package com.example.ezepay.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//Note: 
//We will have the complete merchant details for the specific Merchant ID like Name, web-site, status, phone number


@Entity
public class Merchant {
	
//	public String[] statusArray = {"Active", "Inactive"};

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long merchantId;
	
	private String name;
	private String status;
	private String website;
	private String contact;
	
	
	protected Merchant() {
		// TODO Auto-generated constructor stub : we don't use this 
	}
	
	public Merchant(String name, String status, String website, String contact) {
		
		this.name = name;
		this.status = status;
		this.website = website;
		this.contact = contact;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return this.getName() + " @" + this.getWebsite();
		}
	
	public Long getMerchantId() {
		return merchantId;
	}
	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
}
