package com.abc.bookingdetailservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class BookingDetailserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingDetailserviceApplication.class, args);
	}

}
