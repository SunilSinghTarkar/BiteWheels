package com.bitewheels.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Riders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int riderId;
	@OneToOne
	@JoinColumn(name = "user_id")
	private Users user;
	private int age;
	private String currLocation;
	private String bikeNo;
	private String bikeName;
	private String licenseNo;
	private String aadharNumber;
	private boolean availability;

}
