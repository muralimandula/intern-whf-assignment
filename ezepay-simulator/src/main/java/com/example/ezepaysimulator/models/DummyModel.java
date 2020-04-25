package com.example.ezepaysimulator.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class DummyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long incIdLong;
	
	public String name;
	
	@CreationTimestamp
	public LocalDateTime createdOn;
	
	public Long getIncIdLong() {
		return incIdLong;
	}

	public void setIncIdLong(Long incIdLong) {
		this.incIdLong = incIdLong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	@UpdateTimestamp
	public LocalDateTime updatedOn;
	
	public DummyModel() {
		// TODO Auto-generated constructor stub
	}

	public DummyModel(String name) {
		super();
		this.name = name;
	}
}
