package com.bitewheels.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bitewheels.model.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

}