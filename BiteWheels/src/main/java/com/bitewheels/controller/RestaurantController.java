package com.bitewheels.controller;

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

import com.bitewheels.model.Items;
import com.bitewheels.model.Menus;
import com.bitewheels.model.Orders;
import com.bitewheels.model.Restaurants;
import com.bitewheels.service.ItemService;
import com.bitewheels.service.MenuService;
import com.bitewheels.service.OrderService;
import com.bitewheels.service.RestaurantService;
@CrossOrigin
@RestController
@RequestMapping("restaurants")
public class RestaurantController {
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private MenuService menuService;
	@Autowired
	private OrderService orderService;

	@PostMapping("/register/{userId}")
	public ResponseEntity<Restaurants> registerRestaurant(@PathVariable Integer userId,
			@RequestBody Restaurants restaurant) {

		Restaurants rest = restaurantService.saveRestaurant(userId, restaurant);
		return new ResponseEntity<Restaurants>(rest, HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
	public ResponseEntity<Restaurants> registerRestaurant(@PathVariable Integer userId) {

		Restaurants rest = restaurantService.getByRestaurantId(userId);
		return new ResponseEntity<Restaurants>(rest, HttpStatus.CREATED);
	}

	@PostMapping("/menus/{restaurantId}")
	public ResponseEntity<Menus> addItem(@PathVariable Integer restaurantId, @RequestBody Menus menu) {

		Menus menus = menuService.saveMenu(restaurantId, menu);
		return new ResponseEntity<>(menus, HttpStatus.CREATED);
	}

	@GetMapping("/menus/{menuId}")
	public ResponseEntity<Menus> findMenuById(@PathVariable Integer menuId) {

		Menus menus = menuService.getByMenuId(menuId);
		return new ResponseEntity<>(menus, HttpStatus.CREATED);
	}

	@PostMapping("/items/{menuId}")
	public ResponseEntity<Items> addItem(@PathVariable Integer menuId, @RequestBody Items item) {
		System.out.println(item);
		Items items = itemService.saveItem(menuId, item);
		return new ResponseEntity<>(items, HttpStatus.CREATED);
	}

	@GetMapping("/items/{itemId}")
	public ResponseEntity<Items> addItem(@PathVariable Integer itemId) {

		Items items = itemService.getItemById(itemId);
		return new ResponseEntity<>(items, HttpStatus.CREATED);
	}


}
