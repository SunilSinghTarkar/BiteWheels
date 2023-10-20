package com.bitewheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitewheels.model.Menus;

public interface MenuRepository extends JpaRepository<Menus, Integer> {

}
