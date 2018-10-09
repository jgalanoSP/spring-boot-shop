package com.jgalano.stratpoint.service;

import java.util.List;
import java.util.Optional;

import com.jgalano.stratpoint.model.User;

public interface UserService {
	List<User> getUserList();
	Optional<User> getUser(Long id);
	User findUserByUsername(String username);
	void saveUser(User user);
	void updateUser(User user);
	void deleteUser(Long id);
	
}
