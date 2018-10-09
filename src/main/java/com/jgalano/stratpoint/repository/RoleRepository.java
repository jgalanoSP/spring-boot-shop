package com.jgalano.stratpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jgalano.stratpoint.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
