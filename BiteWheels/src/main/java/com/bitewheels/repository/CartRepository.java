package com.bitewheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitewheels.model.Carts;

public interface CartRepository extends JpaRepository<Carts, Integer> {

}
