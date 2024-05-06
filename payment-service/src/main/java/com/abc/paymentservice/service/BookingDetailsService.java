package com.abc.paymentservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.abc.paymentservice.model.BookingDetails;



@FeignClient(name="BOOKING-DETAILSERVICE")
public interface BookingDetailsService {
	
@GetMapping("/booking/{Id}")
 BookingDetails getBookingDetailById(@PathVariable("Id")int bookingId);
}
