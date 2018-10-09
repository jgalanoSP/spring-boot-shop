package com.jgalano.stratpoint.service;

import java.util.List;
import java.util.Optional;

import com.jgalano.stratpoint.model.Role;

public interface RoleService {
	List<Role> getRoleList();
	Optional<Role> getRole(Long id);
}
