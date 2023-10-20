package com.bitewheels.service;

import java.util.List;

import com.bitewheels.model.Riders;

public interface RiderService {
	public Riders saveRider(Integer userId, Riders rider);

	public Riders getById(Integer riderId);

	public List<Riders> getAllRiders();
}
