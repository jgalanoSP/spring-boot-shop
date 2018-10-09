package com.jgalano.stratpoint.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgalano.stratpoint.model.Role;
import com.jgalano.stratpoint.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Override
	public List<Role> getRoleList() {
		return roleRepository.findAll();
	}

	@Override
	public Optional<Role> getRole(Long id) {
		return roleRepository.findById(id);
	}
	
}
