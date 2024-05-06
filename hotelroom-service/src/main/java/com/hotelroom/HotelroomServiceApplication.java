package com.hotelroom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class HotelroomServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelroomServiceApplication.class, args);
	}

}
