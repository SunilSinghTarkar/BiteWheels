package com.bitewheels.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitewheels.exception.NotFoundException;
import com.bitewheels.model.Carts;
import com.bitewheels.model.Items;
import com.bitewheels.model.OrderItems;
import com.bitewheels.model.Orders;
import com.bitewheels.model.Restaurants;
import com.bitewheels.model.Status;
import com.bitewheels.model.Users;
import com.bitewheels.repository.CartRepository;
import com.bitewheels.repository.OrderItemRepository;
import com.bitewheels.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private UserService userService;
	@Autowired
	private CartRepository cartRepo;
	@Autowired
	private OrderItemRepository orderItemRepo;
	@Autowired
	private ItemService itemService;
	@Autowired
	private RestaurantService restService;

	@Override
	public Orders placeOrder(Integer userId, Integer cartId, Integer restId, Orders order) {
		Users user = userService.getByUserId(userId);
		Carts cart = getCartById(cartId);
		Restaurants restaurant = restService.getByRestaurantId(restId);
		order.setRestaurant(restaurant);
		order.setCart(cart);
		order.setUser(user);
		order.setStatus(Status.PENDING);
		order.setTotalAmount(cart.getTotalAmount());
		Orders orders = orderRepo.save(order);
		return orders;
	}

	public Orders getOrderById(Integer orderId) {
		Orders order = orderRepo.findById(orderId).orElseThrow(() -> new NotFoundException("Order not found!"));
		return order;
	}

	@Override
	public Orders getByOrderId(Integer orderId) {
		Orders order = orderRepo.findById(orderId).orElseThrow(() -> new NotFoundException("Order not found!"));
		return order;
	}

	@Override
	public Carts createCart(Integer userId) {
		Carts cart = new Carts();
		Users user = userService.getByUserId(userId);
		cart.setUser(user);
		cart.setCreationDate(LocalDateTime.now());
		return cartRepo.save(cart);
	}

	@Override
	public Carts getCartById(Integer cartId) {
		Carts cart = cartRepo.findById(cartId).orElseThrow(() -> new NotFoundException("Cart not found!"));

		return cart;

	}

	@Override
	public OrderItems addToCart(Integer cartId, Integer itemId) {
		Items item = itemService.getItemById(itemId);
		Carts cart = getCartById(cartId);
		OrderItems orderItem = new OrderItems();
		orderItem.setItem(item);
		orderItem.setQuantity(1);
		orderItem.setSubtotal(item.getPrice() * orderItem.getQuantity());
		cart.setTotalAmount(cart.getTotalAmount() + orderItem.getSubtotal());
		orderItem.setCart(cart);
		;

		return orderItemRepo.save(orderItem);
	}

	@Override
	public OrderItems incQuantity(Integer orderItemId) {
		OrderItems item = orderItemRepo.findById(orderItemId)
				.orElseThrow(() -> new NotFoundException("OrderItem not found!"));
		item.setQuantity(item.getQuantity() + 1);
		item.setSubtotal(item.getItem().getPrice() * item.getQuantity());
		item.getCart().setTotalAmount(item.getCart().getTotalAmount() + item.getItem().getPrice());
		return orderItemRepo.save(item);
	}

	@Override
	public OrderItems descQuantity(Integer orderItemId) {
		OrderItems item = orderItemRepo.findById(orderItemId)
				.orElseThrow(() -> new NotFoundException("OrderItem not found!"));
		item.setQuantity(item.getQuantity() - 1);
		item.setSubtotal(item.getItem().getPrice() * item.getQuantity());
		item.getCart().setTotalAmount(item.getCart().getTotalAmount() + item.getItem().getPrice());
		return orderItemRepo.save(item);
	}

	@Override
	public String deleteOrderItem(Integer orderItemId) {
		OrderItems item = orderItemRepo.findById(orderItemId)
				.orElseThrow(() -> new NotFoundException("OrderItem not found!"));
		orderItemRepo.delete(item);
		return "OrderItem Removed Succesfully";
	}

	@Override
	public boolean checkInCart(Integer cartId, Integer itemId) {
		Optional<OrderItems> item = orderItemRepo.findOrderItemsByCartIdAndItemId(cartId, itemId);

		return item.isPresent();
	}

}
