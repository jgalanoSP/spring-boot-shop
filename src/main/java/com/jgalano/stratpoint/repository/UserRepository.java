package com.jgalano.stratpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgalano.stratpoint.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
