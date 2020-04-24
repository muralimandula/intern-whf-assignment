package com.example.ezepaysimulator.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DummyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long incIdLong;
}
