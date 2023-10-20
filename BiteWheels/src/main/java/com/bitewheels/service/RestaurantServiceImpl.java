package com.bitewheels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitewheels.exception.NotFoundException;
import com.bitewheels.model.Restaurants;
import com.bitewheels.model.Users;
import com.bitewheels.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	@Autowired
	private RestaurantRepository restaurantRepo;
	@Autowired
	private UserService userService;

	@Override
	public Restaurants saveRestaurant(Integer userId, Restaurants restaurant) {
		Users user = userService.getByUserId(userId);
		restaurant.setOwner(user);
		Restaurants savedRestaurant = restaurantRepo.save(restaurant);
		return savedRestaurant;
	}

	@Override
	public Restaurants getByRestaurantId(Integer restaurantId) {
		Restaurants restaurant = restaurantRepo.findById(restaurantId)
				.orElseThrow(() -> new NotFoundException("Restaurant not found!"));
		return restaurant;
	}

}
