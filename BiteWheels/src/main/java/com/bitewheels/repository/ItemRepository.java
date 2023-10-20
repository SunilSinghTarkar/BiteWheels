package com.bitewheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitewheels.model.Items;

public interface ItemRepository extends JpaRepository<Items, Integer> {

}
