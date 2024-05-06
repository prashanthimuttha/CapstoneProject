package com.abc.bookingdetailservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.bookingdetailservice.model.User;


@FeignClient(name="USER-SERVICE")
public interface UserConsumer {
	
	@GetMapping("/User/{userId}")
	User getUserById(@PathVariable ("userId")int userId);
}
