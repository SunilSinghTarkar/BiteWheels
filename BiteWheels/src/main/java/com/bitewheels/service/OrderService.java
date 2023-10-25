package com.bitewheels.service;

import com.bitewheels.model.Carts;
import com.bitewheels.model.OrderItems;
import com.bitewheels.model.Orders;

public interface OrderService {

	public Orders placeOrder(Integer userId, Integer cartId, Integer restId, Orders order);

	public Orders getByOrderId(Integer orderId);

	public OrderItems addToCart(Integer cartId, Integer itemId);

	public OrderItems incQuantity(Integer orderItemId);

	public OrderItems descQuantity(Integer orderItemId);

	public String deleteOrderItem(Integer orderItemId);

	public Carts createCart(Integer userId);

	public Carts getCartById(Integer cartId);

	public boolean checkInCart(Integer cartId, Integer itemId);

}
