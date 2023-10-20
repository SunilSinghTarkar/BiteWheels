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

import com.bitewheels.model.Orders;
import com.bitewheels.model.Riders;
import com.bitewheels.model.Users;
import com.bitewheels.service.RiderService;
import com.bitewheels.service.UserService;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RiderService riderService;

	@PostMapping("/save")
	public ResponseEntity<Users> saveUser(@RequestBody Users user) {
		Users saved = userService.createUser(user);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/getAll")
	public ResponseEntity<List<Users>> getAllUsers() {
		List<Users> userlist = userService.getAllUser();
		return new ResponseEntity<>(userlist, HttpStatus.OK);
	}

	@PostMapping("/becomerider/{userId}")
	public ResponseEntity<Riders> becomeRider(@PathVariable Integer userId, @RequestBody Riders rider) {
		Riders saved = riderService.saveRider(userId, rider);
		return new ResponseEntity<>(saved, HttpStatus.CREATED);
	}

	@GetMapping("/getAllRiders")
	public ResponseEntity<List<Riders>> getAllRiders() {
		List<Riders> userlist = riderService.getAllRiders();
		return new ResponseEntity<>(userlist, HttpStatus.OK);
	}

	@GetMapping("/getByRiderId/{riderId}")
	public ResponseEntity<Riders> getRider(@PathVariable Integer riderId) {
		Riders rider = riderService.getById(riderId);
		return new ResponseEntity<>(rider, HttpStatus.OK);
	}

	@GetMapping("/getOrderHistory/{userId}")
	public ResponseEntity<List<Orders>> getOrderHistory(@PathVariable Integer userId) {
		List<Orders> orderHistory = userService.orderHistory(userId);
		return new ResponseEntity<>(orderHistory, HttpStatus.OK);
	}

}
