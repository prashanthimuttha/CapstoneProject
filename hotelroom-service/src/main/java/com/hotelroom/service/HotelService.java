package com.hotelroom.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.hotelroom.entity.Hotel;

@Service
public interface HotelService {
	
	 Hotel getHotelById(int hotelId);

	  Hotel createHotel(Hotel hotel);
	  
	  List<Hotel> getAllHotel();
	  
	  Hotel updateHotel(Hotel hotel);
	  
	  void deleteHotel(Hotel hotel);
	  

	  
}
