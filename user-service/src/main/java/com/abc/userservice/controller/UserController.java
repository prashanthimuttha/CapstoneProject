package com.abc.userservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.userservice.entity.User;
import com.abc.userservice.service.UserService;

@RestController
@RequestMapping("/User")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public User createUser(@RequestBody User user) {
		return userService.addUser(user);
	}

	@PutMapping("/{userId}")
	public User updateUser(@PathVariable("userId") int userId, @RequestBody User user) {
		user.setUserId(userId);
		return userService.updateUser(user);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable("userId") int userId) {
		User user = userService.getUserById(userId);
		if (user != null) {
			userService.removeUser(user);
		}
	}

	@GetMapping("/all")
	public List<User> getAllUsers() {
		return userService.showAllUsers();
	}

	@GetMapping("/{userId}")
	public User getUser(@PathVariable int userId) {
		return userService.getUserById(userId);
	}
}
