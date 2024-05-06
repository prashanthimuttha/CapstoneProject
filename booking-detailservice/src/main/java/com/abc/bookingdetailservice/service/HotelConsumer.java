package com.abc.bookingdetailservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.bookingdetailservice.model.Hotel;
import com.abc.bookingdetailservice.model.Room;

@FeignClient(name="HOTELROOM-SERVICE")
public interface HotelConsumer {
	
	 @GetMapping("/hotels/{Id}")
	 Hotel getHotelById(@PathVariable("Id") int hotelId);

	  @GetMapping("/rooms/{Id}")
	Room getRoomDetailsById(@PathVariable("Id") int roomId);

}
