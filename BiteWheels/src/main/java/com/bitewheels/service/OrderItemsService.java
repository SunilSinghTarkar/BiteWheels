package com.bitewheels.service;

import com.bitewheels.model.OrderItems;

public interface OrderItemsService {
	public OrderItems selectItem(OrderItems item);

	public OrderItems getOrderItem(Integer itemId);

}
