package com.hotelroom.testservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import com.hotelroom.entity.Hotel;
import com.hotelroom.entity.Room;
import com.hotelroom.model.RoomModel;
import com.hotelroom.repository.HotelRepository;
import com.hotelroom.repository.RoomDetailsRepository;
import com.hotelroom.service.HotelServiceImpl;
import com.hotelroom.service.RoomDetailsServiceImpl;
@SpringBootTest
public class HotelTest {
	

	@InjectMocks
	private HotelServiceImpl  hotelService;
	@InjectMocks
	private RoomDetailsServiceImpl roomDetailService;
	@Mock
	private HotelRepository hotelRepository;
	@Mock
	private RoomDetailsRepository 	roomDetailsRepository;
	
	
	@Test
	public void testcreateHotel() {
		
		Hotel hotel =new Hotel();
		hotel.setHotelId(1);
		hotel.setHotelName("GayathriHotel");
		hotel.setAddress("Tuni");
		hotel.setDescription("superuxuryHotel");
		hotel.setCity("Tuni");
		hotel.setAvgRatePerDay(2000);
		hotel.setEmail("Gayatri@gmail.com");
		hotel.setPhone1("9632588741");
		hotel.setPhone2("7895641232");
		hotel.setWebsite("www.gayatri.com");
		
		
		when(hotelRepository.save(hotel)).thenReturn(hotel);

        // Call the createHotel method
        Hotel createdHotel = hotelService.createHotel(hotel);
        verify(hotelRepository, times(1)).save(hotel);		
		assertNotNull(createdHotel);
		assertEquals(hotel.getHotelId(),createdHotel.getHotelId());
		assertEquals(hotel.getHotelName(),createdHotel.getHotelName());
		assertEquals(hotel.getEmail(),createdHotel.getEmail());
	}
	@Test
	public void testDeleteHotel() {
		
		Hotel hotel=new Hotel();
		
		hotel.setHotelId(10);
		hotel.setHotelName("Novtel");
		hotel.setAddress("BeachRoad");
		hotel.setDescription("BeachView");
		hotel.setCity("Vizag");
		hotel.setAvgRatePerDay(3000);
		hotel.setEmail("Novtel@gmail.com");
		hotel.setPhone1("8523697410");
		hotel.setPhone2("85693214701");
		hotel.setWebsite("www.Novtel.com");
		
		
		when(hotelRepository.findById(10)).thenReturn(Optional.of(hotel));

		doNothing().when(hotelRepository).delete(hotel);

		hotelService.deleteHotel(hotel);

	}
	@Test
	public void testGetHotelById() {
		
       Hotel hotel=new Hotel();
		
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

		when(hotelRepository.findById(101)).thenReturn(Optional.of(hotel));

		Hotel hotelList = hotelService.getHotelById(101);
		assertEquals(101, hotelList.getHotelId());


		
		
		
		
	}
	
	@Test
	public void testGetAllHotel() {
		Hotel hotel=new Hotel();
		
		hotel.setHotelId(110);
		hotel.setHotelName("GreenPark");
		hotel.setAddress("RamNagar");
		hotel.setDescription("Good");
		hotel.setCity("Hyderabad");
		hotel.setAvgRatePerDay(1500);
		hotel.setEmail("Greean@gmail.com");
		hotel.setPhone1("7789944555");
		hotel.setPhone2("9988774455");
		hotel.setWebsite("www.Green@gmail.com");
		
		
        Hotel hotel1=new Hotel();
		
		hotel.setHotelId(111);
		hotel.setHotelName("VivekHotel");
		hotel.setAddress("Bihar");
		hotel.setDescription("good");
		hotel.setCity("bihar");
		hotel.setAvgRatePerDay(2000);
		hotel.setEmail("Vivek@gmail.com");
		hotel.setPhone1("7412589630");
		hotel.setPhone2("8547963210");
		hotel.setWebsite("www.Vivek.com");
		
		
		List<Hotel> hotels = new ArrayList<>();
		hotels.add(hotel);
		hotels.add(hotel1);

		when(hotelRepository.findAll()).thenReturn(hotels);

		List<Hotel> hotelList = hotelService.getAllHotel();
		assertEquals(2, hotelList.size());

		
	}
	
	
	
	@Test
	public void testUpdateHotel() {
	    Hotel hotel = new Hotel();
	    hotel.setHotelId(1);
	    hotel.setHotelName("GayathriHotel");
	    hotel.setAddress("Tuni");
	    hotel.setDescription("superluxuryHotel");
	    hotel.setCity("Tuni");
	    hotel.setAvgRatePerDay(2000);
	    hotel.setEmail("Gayatri@gmail.com");
	    hotel.setPhone1("9632588741");
	    hotel.setPhone2("7895641232");
	    hotel.setWebsite("www.gayatri.com");
	    
	    
	    when(hotelRepository.findById(1)).thenReturn(Optional.of(hotel));
	    when(hotelRepository.save(Mockito.any(Hotel.class))).thenReturn(hotel);

	    Hotel updatedHotel = hotelService.updateHotel(hotel);

	    verify(hotelRepository, times(1)).findById(1);
	    verify(hotelRepository, times(1)).save(hotel);


		assertEquals(hotel.getHotelId(), updatedHotel.getHotelId());
	    assertEquals(hotel.getHotelName(), updatedHotel.getHotelName());
	    assertEquals(hotel.getEmail(), updatedHotel.getEmail());
	    assertEquals(hotel.getAddress(), updatedHotel.getAddress());
	    assertEquals(hotel.getDescription(), updatedHotel.getDescription());
	    assertEquals(hotel.getCity(), updatedHotel.getCity());
	    assertEquals(hotel.getAvgRatePerDay(), updatedHotel.getAvgRatePerDay());
	    assertEquals(hotel.getPhone1(), updatedHotel.getPhone1());
	    assertEquals(hotel.getPhone2(), updatedHotel.getPhone2());
	    assertEquals(hotel.getWebsite(), updatedHotel.getWebsite());
		
		
	}

	    @Test
	    public void testCreateRoomDetails() {
	        // Create sample data
	        Hotel hotel = new Hotel();
	        hotel.setHotelId(10);
			RoomModel room1=new RoomModel();

	        room1.setRoomId(101);
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
	    		hotel.setHotelId(10);
	    		
	    		
	    		
	    	        when(roomDetailsRepository.save(room)).thenReturn(room);

	    	        Room createdRoom = roomDetailService.createRoomDetails(room1);

	    	        verify(roomDetailsRepository, times(1)).save(createdRoom);		
	    		assertNotNull(createdRoom);
	    		assertEquals(room.getRoomId(),createdRoom.getRoomId());
	    		assertEquals(room.getRoomType(),createdRoom.getRoomType());
	    		
	    	}
	}


	


	 
	
		
		 
		 
	 
	
		

