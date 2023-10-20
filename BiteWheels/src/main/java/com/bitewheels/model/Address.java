package com.bitewheels.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Address {
	private String address;
	private int pincode;
	private String city;
	private String state;

}
