package com.bitewheels.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Items")
public class Items {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int itemId;
	@JsonIgnore
	@ManyToOne
	private Menus menu;
	private String name;
	private String description;
	private double price;
	private String imageUrl;
	@JsonIgnore
	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private List<OrderItems> orderItem = new ArrayList<>();
	private boolean availability;

	@Override
	public String toString() {
		return "Items [itemId=" + itemId + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", imageUrl=" + imageUrl + ", availability=" + availability + "]";
	}

}
