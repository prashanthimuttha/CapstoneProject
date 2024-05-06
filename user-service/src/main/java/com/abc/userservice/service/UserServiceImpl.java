package com.abc.userservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.userservice.entity.User;
import com.abc.userservice.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public User addUser(User user) {
		userRepository.save(user);
		return user; 
	}

	@Override
	public User updateUser(User user) {
		userRepository.save(user);
return user;
	}

	@Override
	public User removeUser(User user) {
userRepository.delete(user);	
return user;
	}

	@Override
	public List<User> showAllUsers() {
		List<User> userList=userRepository.findAll();
		return userList;
	}

	@Override
	public User getUserById(int userId) {
		return userRepository.findById(userId).orElse(null);
		
	}

}
