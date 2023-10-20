package com.bitewheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitewheels.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
