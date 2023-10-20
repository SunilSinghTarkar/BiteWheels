package com.bitewheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitewheels.model.Riders;

public interface RiderRepository extends JpaRepository<Riders, Integer> {

}
