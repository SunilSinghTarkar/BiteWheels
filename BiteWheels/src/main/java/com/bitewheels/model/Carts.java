package com.bitewheels.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Carts {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cardId;
	private LocalDateTime creationDate;
	private double totalAmount;
	@JsonIgnore
	@OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
	private Orders order;
	@OneToMany(mappedBy = "cart")
	private List<OrderItems> orderItems = new ArrayList<>();
}
