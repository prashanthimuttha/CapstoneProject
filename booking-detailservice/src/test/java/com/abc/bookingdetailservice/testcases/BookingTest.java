package com.abc.bookingdetailservice.testcases;

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
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.bookingdetailservice.entity.BookingDetails;
import com.abc.bookingdetailservice.repository.BookingDetailRepository;
import com.abc.bookingdetailservice.service.BookingDetailServiceImpl;


@SpringBootTest
public class BookingTest {

	@InjectMocks
	private BookingDetailServiceImpl bookingService;
	@Mock
	private BookingDetailRepository bookingRepository;
	@Test
	public void testAddBookingDetails() {
		
		BookingDetails booking=new BookingDetails();
		booking.setBookingId(10);
		booking.setRoomId(100);
		booking.setUserId(1);
		booking.setHotelId(111);
		booking.setNoOfAdults(2);
		booking.setNoOfChildren(1);
		booking.setBookedFrom("2024-05-13");
		booking.setBookedTo("2024-05-15");
		booking.setAmount("4000");
		when(bookingRepository.save(booking)).thenReturn(booking);

		BookingDetails savedUser = bookingService.addBookingDetails(booking);
		verify(bookingRepository, times(1)).save(booking);

		assertNotNull(savedUser);
		assertEquals(booking.getUserId(),savedUser.getUserId());
		assertEquals(booking.getRoomId(),savedUser.getRoomId());
		assertEquals(booking.getHotelId(),savedUser.getHotelId());
		
	}
	@Test
	public void testDeleteBookingDetails() {
		
		BookingDetails booking=new BookingDetails();
		booking.setBookingId(10);
		booking.setHotelId(111);
		booking.setUserId(2);
		booking.setRoomId(101);
		booking.setBookedFrom("2024-05-13");
		booking.setBookedTo("2024-05-12");
		booking.setNoOfAdults(2);
		booking.setNoOfChildren(0);
		booking.setAmount("2000");
		
		when(bookingRepository.findById(10)).thenReturn(Optional.of(booking));

		doNothing().when(bookingRepository).delete(booking);

		bookingService.deleteBookingDetails(10);

		
	}
	@Test
	public void tesgetBookingDetailById() {
		
		BookingDetails  booking =new BookingDetails();
		booking.setBookingId(11);
		booking.setUserId(2);
		booking.setHotelId(112);
		booking.setRoomId(102);
		booking.setBookedTo("2024=06-1");
		booking.setBookedFrom("2024-06-5");
		booking.setNoOfAdults(3);
		booking.setNoOfChildren(2);
		booking.setAmount("6000");
		
		
	}
	@Test
	public void testGetAllBookingDetails() {
		BookingDetails booking=new BookingDetails();
		
		booking.setBookingId(13);
		booking.setHotelId(115);
		booking.setRoomId(103);
		booking.setUserId(3);
		booking.setBookedFrom("2024-05-25");
		booking.setBookedTo("2024-05-26");
		booking.setNoOfAdults(2);
		booking.setNoOfChildren(0);
		booking.setAmount("2500");
		
		BookingDetails booking1=new BookingDetails();
		booking.setBookingId(14);
		booking.setHotelId(116);
		booking.setUserId(4);
		booking.setRoomId(104);
		booking.setBookedFrom("2024-06-12");
		booking.setBookedTo("2024-06-14");
        booking.setNoOfAdults(1);
        booking.setNoOfChildren(0);
        booking.setAmount("1000");
        
        
        List<BookingDetails> bookingDetails = new ArrayList<>();
        bookingDetails.add(booking);
        bookingDetails.add(booking1);

		when(bookingRepository.findAll()).thenReturn(bookingDetails);

		List<BookingDetails> bookingList = bookingService.getAllBookingDetails();
		assertEquals(2, bookingList.size());

	}
	
	@Test
	public void testUpdateBookingDetails() {
		 BookingDetails booking = new BookingDetails();
	        booking.setBookingId(1);
	        booking.setRoomId(101);
	        booking.setUserId(1);
	        booking.setHotelId(1);
	        booking.setBookedFrom("2024-05-01");
	        booking.setBookedTo("2024-05-03");
	        booking.setNoOfAdults(2);
	        booking.setNoOfChildren(1);
	        booking.setAmount("3000");

	        Mockito.when(bookingRepository.save(Mockito.any(BookingDetails.class))).thenReturn(booking);

	        BookingDetails updatedBooking = bookingService.updateBookingDetails(booking);

	        Mockito.verify(bookingRepository, Mockito.times(1)).save(booking);
	        assertNotNull(updatedBooking);
	        assertEquals(booking, updatedBooking);
	    }
	
	

}
