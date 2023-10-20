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
import lombok.Data;

@Data
@Entity
public class Menus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int menuId;
	private String name;
	private String description;
	@ManyToOne
	private Restaurants restaurant;
	@OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
	private List<Items> items = new ArrayList<>();

	@Override
	public String toString() {
		return "Menus [menuId=" + menuId + ", name=" + name + ", description=" + description + ", items=" + items + "]";
	}

}
