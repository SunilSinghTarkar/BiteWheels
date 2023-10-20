package com.bitewheels.service;

import com.bitewheels.model.Restaurants;

public interface RestaurantService {
	public Restaurants saveRestaurant(Integer userId, Restaurants restaurant);

	public Restaurants getByRestaurantId(Integer restaurantId);
}
