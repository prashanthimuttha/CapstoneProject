package com.abc.userservice.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.userservice.entity.User;
import com.abc.userservice.repository.UserRepository;
import com.abc.userservice.service.UserServiceImpl;

@SpringBootTest
public class UserTest {

	@InjectMocks
	private UserServiceImpl userService;
	@Mock
	private UserRepository userRepository;
	
	@Test
	public void testAddUser() {
		User user=new User();
		user.setUserId(101);
		user.setUserName("Prashanthi");
		user.setEmail("Prashanthimuttha@gmail.com");
		user.setPassword("12345");
		user.setRole("User");
		user.setMobile("9948038654");
		user.setAddress("Tuni");
		when(userRepository.save(user)).thenReturn(user);

		User savedUser = userService.addUser(user);
		verify(userRepository, times(1)).save(user);

		assertNotNull(savedUser);
		assertEquals(user.getUserId(),savedUser.getUserId());
		assertEquals(user.getUserName(),savedUser.getUserName());
		assertEquals(user.getEmail(),savedUser.getEmail());
		
	}
	
	@Test
	public void testDeleteUser() {
		
		User user=new User();
		
		user.setUserId(102);
		user.setUserName("Alkehya");
		user.setEmail("Alekhya@gmail.com");
		user.setPassword("12345");
		user.setMobile("7894561203");
		user.setRole("user");
		user.setAddress("Vizag");
		
		when(userRepository.findById(102)).thenReturn(Optional.of(user));

		doNothing().when(userRepository).delete(user);

		userService.removeUser(user);

		
	}
	
	
	
	
	@Test
	public void testShowAllUsers() {
		
		User user=new User();
		user.setUserId(10);
		user.setUserName("Seetha");
		user.setEmail("sita@gmail.com");
		user.setPassword("1478");
		user.setRole("user");
		user.setMobile("9874562310");
		user.setAddress("Narsipatnam");
		
		User user1=new User();
		user1.setUserId(11);
		user1.setUserName("Hani");
		user1.setEmail("Hani@gmail.com");
		user1.setPassword("1256");
		user1.setRole("user");
		user1.setMobile("8854562310");
		user1.setAddress("Suravaram");
		
		User user2=new User();
		user2.setUserId(12);
		user2.setUserName("Akshit");
		user2.setEmail("Akshit@gmail.com");
		user2.setPassword("12365");
		user2.setRole("user");
		user2.setMobile("9865982310");
		user2.setAddress("Goa");
		
		List<User> users = new ArrayList<>();
		users.add(user);
		users.add(user1);
		users.add(user2);

		when(userRepository.findAll()).thenReturn(users);

		List<User> userList = userService.showAllUsers();
		assertEquals(3, userList.size());

		
	}
	
	@Test
	public void testGetUserById() {
		
		User user=new User();
		
		user.setUserId(111);
		user.setUserName("Tarun");
		user.setEmail("Tarun@gmail.com");
		user.setMobile("9845789654");
		user.setPassword("2589");
		user.setRole("user");
		user.setAddress("Polavaram");
		
	}
	
	

}
