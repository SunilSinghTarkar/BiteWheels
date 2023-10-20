package com.bitewheels.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitewheels.exception.NotFoundException;
import com.bitewheels.model.Menus;
import com.bitewheels.model.Restaurants;
import com.bitewheels.repository.MenuRepository;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired
	private MenuRepository menuRepo;
	@Autowired
	private RestaurantService restService;

	@Override
	public Menus saveMenu(Integer restaurantId, Menus menu) {
		Restaurants restaurant = restService.getByRestaurantId(restaurantId);
		menu.setRestaurant(restaurant);
		return menuRepo.save(menu);
	}

	@Override
	public Menus getByMenuId(Integer menuId) {
		Menus menu = menuRepo.findById(menuId).orElseThrow(() -> new NotFoundException("Menu not found!"));
		return menu;
	}

}
