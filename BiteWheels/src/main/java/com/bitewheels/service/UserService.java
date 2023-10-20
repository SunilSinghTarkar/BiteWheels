package com.bitewheels.service;

import java.util.List;

import com.bitewheels.model.Orders;
import com.bitewheels.model.Users;

public interface UserService {
	public Users createUser(Users user);

	public Users getByUserId(Integer userId);

	public List<Users> getAllUser();

	public List<Orders> orderHistory(Integer userId);
}
