package com.bitewheels.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bitewheels.model.OrderItems;

public interface OrderItemRepository extends JpaRepository<OrderItems, Integer> {
	
	@Query("SELECT oi FROM OrderItems oi WHERE oi.cart.cartId = :cartId AND oi.item.itemId = :itemId")
	Optional<OrderItems> findOrderItemsByCartIdAndItemId(int cartId, int itemId);

}
