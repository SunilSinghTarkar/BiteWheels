package com.bitewheels.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bitewheels.model.Riders;
import com.bitewheels.service.RiderService;
@CrossOrigin
@RestController
@RequestMapping("/riders")
public class RiderController {
	@Autowired
	private RiderService riderService;

	@PostMapping("/becomeRider/{userId}")
	public ResponseEntity<Riders> becomeRider(@PathVariable Integer userId, @RequestBody Riders rider) {
		Riders riders = riderService.saveRider(userId, rider);
		return new ResponseEntity<Riders>(riders, HttpStatus.CREATED);
	}

	@GetMapping("/{riderId}")
	public ResponseEntity<Riders> becomeRider(@PathVariable Integer riderId) {
		Riders riders = riderService.getById(riderId);
		return new ResponseEntity<Riders>(riders, HttpStatus.CREATED);
	}

	@GetMapping("/getAllRiders")
	public ResponseEntity<List<Riders>> becomeRider() {
		List<Riders> riders = riderService.getAllRiders();
		return new ResponseEntity<>(riders, HttpStatus.CREATED);
	}

}
