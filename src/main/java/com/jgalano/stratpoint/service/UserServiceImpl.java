package com.jgalano.stratpoint.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jgalano.stratpoint.model.Role;
import com.jgalano.stratpoint.model.User;
import com.jgalano.stratpoint.repository.RoleRepository;
import com.jgalano.stratpoint.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public List<User> getUserList() {
		return userRepository.findAll();
	}

	@Override
	public Optional<User> getUser(Long id) {
		return userRepository.findById(id);
	}
	
	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public void saveUser(User user) {
	
		Role role = roleRepository.findByName("USER");
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRole(role);
		userRepository.save(user);	
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(user);	
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
