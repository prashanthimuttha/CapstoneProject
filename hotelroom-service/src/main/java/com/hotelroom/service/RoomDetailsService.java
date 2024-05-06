package com.hotelroom.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelroom.entity.Room;
import com.hotelroom.model.RoomModel;


@Service
public interface RoomDetailsService {
	
		Room getRoomDetailsById(int roomId);

		Room createRoomDetails(RoomModel roomDetails);
		
		void deleteRoomDetails(int roomId);
		
		List<Room> getAllRoomDetails();
		
		Room updateRoom(Room room);
	 
	 

}
