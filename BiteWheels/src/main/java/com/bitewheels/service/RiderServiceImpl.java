package com.bitewheels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitewheels.exception.NotFoundException;
import com.bitewheels.model.Riders;
import com.bitewheels.model.Roles;
import com.bitewheels.model.Users;
import com.bitewheels.repository.RiderRepository;
import com.bitewheels.repository.UserRepository;

@Service
public class RiderServiceImpl implements RiderService {
	@Autowired
	private RiderRepository riderRepo;
	@Autowired
	private UserRepository userRepo;

	@Override
	public Riders saveRider(Integer userId, Riders rider) {
		Users user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("User not found!"));
		user.setRole(Roles.RIDER);
		rider.setUser(user);
		rider.setAvailability(true);

		return riderRepo.save(rider);
	}

	@Override
	public List<Riders> getAllRiders() {
		return riderRepo.findAll();

	}

	@Override
	public Riders getById(Integer riderId) {
		Riders rider = riderRepo.findById(riderId).orElseThrow(() -> new NotFoundException("Rider not found!"));
		return rider;
	}

}
