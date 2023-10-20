package com.bitewheels.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	@ManyToOne
	private Users user;
	@ManyToOne
	private Restaurants restaurant;
	private LocalDateTime orderTime;
	@Embedded
	private Address deliveryAdd;
	private String deliveryAddress;

	@OneToOne
	private Carts cart;
	private double totalAmount;
	@Enumerated(EnumType.STRING)
	private Status status;
}
