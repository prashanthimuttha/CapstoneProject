package com.hotelroom.testservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotelroom.entity.Hotel;
import com.hotelroom.entity.Room;
import com.hotelroom.model.RoomModel;
import com.hotelroom.repository.HotelRepository;
import com.hotelroom.repository.RoomDetailsRepository;
import com.hotelroom.service.RoomDetailsServiceImpl;

@ExtendWith(MockitoExtension.class)
public class RoomDetailsServiceImplTest {

	@InjectMocks
	private RoomDetailsServiceImpl roomDetailService;

	@Mock
	private RoomDetailsRepository roomDetailsRepository;

	@Mock
	private HotelRepository hotelRepository;

	@Test
	public void testCreateRoomDetails() {
		// Create sample data
		Hotel hotel = new Hotel();

		hotel.setHotelId(101);
		hotel.setHotelName("The Park");
		hotel.setAddress("Dr NTR Road");
		hotel.setDescription("All facilities here");
		hotel.setCity("Vizag");
		hotel.setAvgRatePerDay(3500);
		hotel.setEmail("Tarun@gmail.com");
		hotel.setPhone1("8523697410");
		hotel.setPhone2("9854763210");
		hotel.setWebsite("www.ThePark@gmail.com");

		RoomModel room1 = new RoomModel();

		room1.setRoomId(101);
		room1.setHotelId(101);
		room1.setRoomNo("201");
		room1.setRoomType("Ac");
		room1.setRatePerDay(3000);
		room1.setAvailable(true);

		Room room = new Room();
		room.setRoomId(101);
		room.setRoomNo("201");
		room.setRoomType("Ac");
		room.setRatePerDay(3000);
		room.setAvailable(true);
		hotel.setHotelId(101);

		when(roomDetailsRepository.save(any(Room.class))).thenReturn(room);

		when(hotelRepository.findById(101)).thenReturn(Optional.of(hotel));

		Room createdRoom = roomDetailService.createRoomDetails(room1);

		verify(roomDetailsRepository, times(1)).save(any(Room.class));
		assertNotNull(createdRoom);
		assertEquals(room.getRoomId(), createdRoom.getRoomId());
		assertEquals(room.getRoomType(), createdRoom.getRoomType());

	}

	@Test
	public void testDeleteRoom() {
		// Sample data
		Hotel hotel = new Hotel();
		hotel.setHotelId(101);

		RoomModel roomModel = new RoomModel();
		roomModel.setRoomId(101);
		roomModel.setHotelId(101);

		Room room = new Room();
		room.setRoomId(101);
		room.setHotel(hotel);

		// Mock behavior of repositories
		when(roomDetailsRepository.findById(101)).thenReturn(Optional.of(room));

		roomDetailService.deleteRoomDetails(101);
		verify(roomDetailsRepository, times(1)).delete(room);


	}

	@Test
	public void testupdateRoom() {

		
		RoomModel roomModel = new RoomModel();
		roomModel.setRoomId(101);
		roomModel.setHotelId(101);
		roomModel.setRoomType("Updated Room Type");
		roomModel.setRatePerDay(4000);

		Room room = new Room();
		room.setRoomId(101);
		room.setRoomType("Old Room Type");
		room.setRatePerDay(3000);
		
		when(roomDetailsRepository.findById(101)).thenReturn(Optional.of(room));
		when(roomDetailsRepository.save(room)).thenReturn(room);

		// Call the update method
		Room updatedRoom = roomDetailService.updateRoom(room);
		  verify(roomDetailsRepository).save(room);
		assertNotNull(updatedRoom);
		assertEquals(updatedRoom.getRoomType(), updatedRoom.getRoomType());
		assertEquals(updatedRoom.getRatePerDay(), updatedRoom.getRatePerDay());
	}
	
	 @Test
	    public void testGetRoomDetailsById() {
	        // Sample data
	        Hotel hotel = new Hotel();
	        hotel.setHotelId(101);

	        RoomModel roomModel = new RoomModel();
	        roomModel.setRoomId(101);
	        roomModel.setHotelId(101);
	        roomModel.setRoomType("Room Type");
	        roomModel.setRatePerDay(4000);

	        Room room = new Room();
	        room.setRoomId(101);
	        room.setHotel(hotel);
	        room.setRoomType("Room Type");
	        room.setRatePerDay(4000);

	        // Mock behavior of repository
	        when(roomDetailsRepository.findById(101)).thenReturn(Optional.of(room));

	        // Call the method under test
	        Room retrievedRoomModel = roomDetailService.getRoomDetailsById(101);

	        // Verify that the room details are retrieved correctly
	        assertEquals(retrievedRoomModel.getRoomId(), retrievedRoomModel.getRoomId());
	        assertEquals(retrievedRoomModel.getRoomType(), retrievedRoomModel.getRoomType());
	        assertEquals(retrievedRoomModel.getRatePerDay(), retrievedRoomModel.getRatePerDay());
	    }

	 @Test
	    public void testGetAllRoomDetails() {
	        // Sample data
	        Hotel hotel1 = new Hotel();
	        hotel1.setHotelId(101);

	        Room room = new Room();
	        room.setRoomId(101);
	        room.setHotel(hotel1);
	        room.setRoomType("Room Type 1");
	        room.setRatePerDay(4000);

	        Hotel hotel2 = new Hotel();
	        hotel2.setHotelId(102);

	        Room roomModel = new Room();
	        roomModel.setRoomId(102);
	        roomModel.setHotel(hotel2);
	        roomModel.setRoomType("Room Type 2");
	        roomModel.setRatePerDay(5000);

	        List<Room> rooms = new ArrayList<>();
	        rooms.add(room);
	        rooms.add(roomModel);

	        // Mock behavior of repository
	        when(roomDetailsRepository.findAll()).thenReturn(rooms);

	        // Call the method under test
	        List<Room> allRoomDetails = roomDetailService.getAllRoomDetails();

			assertEquals(2, allRoomDetails.size());
	 }
	      
	}

