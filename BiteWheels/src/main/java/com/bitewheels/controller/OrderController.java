package com.bitewheels.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bitewheels.model.Carts;
import com.bitewheels.model.OrderItems;
import com.bitewheels.model.Orders;
import com.bitewheels.service.OrderService;

@CrossOrigin
@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@PostMapping("/carts")
	public ResponseEntity<Carts> createCart() {
		Carts cart = orderService.createCart();
		return new ResponseEntity<Carts>(cart, HttpStatus.CREATED);
	}

	@GetMapping("/carts/{cartId}")
	public ResponseEntity<Carts> findCartById(@PathVariable Integer cartId) {
		Carts cart = orderService.getCartById(cartId);
		return new ResponseEntity<Carts>(cart, HttpStatus.CREATED);
	}

	@PostMapping("/addtocarts/{cartId}/{itemId}")
	public ResponseEntity<OrderItems> addToCart(@PathVariable Integer cartId, @PathVariable Integer itemId) {
		OrderItems orderItem = orderService.addToCart(cartId, itemId);
		return new ResponseEntity<>(orderItem, HttpStatus.CREATED);
	}

	@PatchMapping("/carts/incQuantity/{orderItemId}")
	public ResponseEntity<OrderItems> incQuantity(@PathVariable Integer orderItemId) {
		OrderItems orderItem = orderService.incQuantity(orderItemId);
		return new ResponseEntity<>(orderItem, HttpStatus.OK);
	}

	@PatchMapping("/carts/descQuantity/{orderItemId}")
	public ResponseEntity<OrderItems> descQuantity(@PathVariable Integer orderItemId) {
		OrderItems orderItem = orderService.descQuantity(orderItemId);
		return new ResponseEntity<>(orderItem, HttpStatus.OK);
	}

	@DeleteMapping("/carts/removeOrderItems/{orderItemId}")
	public ResponseEntity<String> deleteOrderItem(@PathVariable Integer orderItemId) {
		String orderItem = orderService.deleteOrderItem(orderItemId);
		return new ResponseEntity<>(orderItem, HttpStatus.OK);
	}

	@PostMapping("/placeOrder/{userId}/{cartId}/{restId}")
	public ResponseEntity<Orders> placeOrder(@PathVariable Integer userId, @PathVariable Integer cartId,
			@PathVariable Integer restId, @RequestBody Orders order) {
		Orders orders = orderService.placeOrder(userId, cartId, restId, order);
		return new ResponseEntity<>(orders, HttpStatus.CREATED);
	}

	@GetMapping("/getOrder/{orderId}")
	public ResponseEntity<Orders> placeOrder(@PathVariable Integer orderId) {
		Orders orders = orderService.getByOrderId(orderId);
		return new ResponseEntity<>(orders, HttpStatus.OK);
	}

}
