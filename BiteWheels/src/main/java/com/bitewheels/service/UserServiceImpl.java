package com.bitewheels.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitewheels.exception.NotFoundException;
import com.bitewheels.model.Orders;
import com.bitewheels.model.Roles;
//import com.bitewheels.model.Roles;
import com.bitewheels.model.Users;
import com.bitewheels.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public Users createUser(Users user) {
		user.setRole(Roles.CUSTOMER);
		return userRepo.save(user);

	}

	@Override
	public List<Users> getAllUser() {

		return userRepo.findAll();
	}

	@Override
	public Users getByUserId(Integer userId) {
		Users user = userRepo.findById(userId).orElseThrow(() -> new NotFoundException("User not found!"));
		return user;
	}

	@Override
	public List<Orders> orderHistory(Integer userId) {
		Users user = getByUserId(userId);

		return user.getOrderHistory();
	}

}
