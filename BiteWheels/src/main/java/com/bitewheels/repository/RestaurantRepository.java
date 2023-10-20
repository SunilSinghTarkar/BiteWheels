package com.bitewheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitewheels.model.Restaurants;

public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {

}
