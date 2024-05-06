package com.hotelroom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelroom.entity.Hotel;
import com.hotelroom.entity.Room;
import com.hotelroom.exception.ResourceNotFoundException;
import com.hotelroom.model.RoomModel;
import com.hotelroom.repository.RoomDetailsRepository;
import com.hotelroom.repository.HotelRepository;
@Service
public class RoomDetailsServiceImpl implements RoomDetailsService {

	@Autowired
	private RoomDetailsRepository roomDetailsRepository;
	
	@Autowired
	private HotelRepository hotelRepository;
	
	
	@Override
	public Room getRoomDetailsById(int roomId) {
		Optional<Room> optionalRoomDetails = roomDetailsRepository.findById(roomId);
		
		if(optionalRoomDetails.isEmpty()) {
			throw new ResourceNotFoundException("Room Details not found"+roomId);
		}
		Room roomDetails = optionalRoomDetails.get();
		
		return roomDetails;
	}


	@Override
	public void deleteRoomDetails(int roomId) {
		Optional<Room> optionalRoomDetails = roomDetailsRepository.findById(roomId);
		
		if(optionalRoomDetails.isEmpty()) {
			throw new ResourceNotFoundException("Room Details not found"+roomId);
		}
		Room room = optionalRoomDetails.get();
		roomDetailsRepository.delete(room);
		
	}

	@Override
	public List<Room> getAllRoomDetails() {
		List<Room> roomDetails = roomDetailsRepository.findAll();
		return roomDetails;
	}


	@Override
	public Room createRoomDetails(RoomModel roomDetails) {
			Optional<Hotel> hotel = hotelRepository.findById(roomDetails.getHotelId());
			if(hotel.isEmpty()) {
				throw new ResourceNotFoundException("Hotel not found with Id"+roomDetails.getHotelId());			
			}
			
			Room rooms =new Room();
			
			rooms.setHotel(hotel.get());
			rooms.setRoomNo(roomDetails.getRoomNo());
			rooms.setRoomType(roomDetails.getRoomType());
			rooms.setRatePerDay(roomDetails.getRatePerDay());
			rooms.setAvailable(roomDetails.isAvailable());
			
			return roomDetailsRepository.save(rooms);
			
	}


	@Override
	public Room updateRoom(Room room) {
		Optional<Room> optionalroom = roomDetailsRepository.findById(room.getRoomId());

		if (optionalroom.isEmpty()) {
			throw new ResourceNotFoundException("Hotel Not found with id "+room.getRoomId());

		}
		return roomDetailsRepository.save(room);
	
	}


	


	
}
