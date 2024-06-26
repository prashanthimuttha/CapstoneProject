package com.hotelroom.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelroom.entity.Hotel;
import com.hotelroom.service.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {

  @Autowired
  private HotelService hotelService;

  @GetMapping("/{Id}")
  public ResponseEntity<Hotel> getHotel(@PathVariable("Id") int hotelId) {
    Hotel hotel = hotelService.getHotelById(hotelId);
    
      return new ResponseEntity<>(hotel,HttpStatus.OK);
    }

  @PostMapping("/save")
  public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel) {
	  hotelService.createHotel(hotel);
	  ResponseEntity<Hotel> responseEntity = new ResponseEntity<>(HttpStatus.CREATED);	  
    return responseEntity;
  }

  @GetMapping("/all")
	public List<Hotel> fetchAllHotels() {

		List<Hotel> hotels = hotelService.getAllHotel();
		return hotels;
	}
	@PutMapping("/update")
	public ResponseEntity<Hotel> editHotel(@RequestBody Hotel hotel) {
		hotelService.updateHotel(hotel);
		ResponseEntity<Hotel> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteHotel(@PathVariable("id") int hotelId) {
		Hotel hotel = hotelService.getHotelById(hotelId);
		if (hotel != null) {
			hotelService.deleteHotel(hotel);
		}
		ResponseEntity<Void> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;

	}

}
