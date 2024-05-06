package com.abc.bookingdetailservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.bookingdetailservice.entity.BookingDetails;
import com.abc.bookingdetailservice.exception.ResourceNotFoundException;
import com.abc.bookingdetailservice.model.BookingPayload;
import com.abc.bookingdetailservice.model.Hotel;
import com.abc.bookingdetailservice.model.Room;
import com.abc.bookingdetailservice.model.User;
import com.abc.bookingdetailservice.repository.BookingDetailRepository;

	@Service
	public class BookingDetailServiceImpl implements BookingDetailsService {
	    @Autowired
	    private BookingDetailRepository bookingDetailsRepository;
	    @Autowired
	    private HotelConsumer hotelService;
	    @Autowired
	    private UserConsumer userService;
	    
	    @Override
	    public List<BookingDetails> getAllBookingDetails() {
	        return bookingDetailsRepository.findAll();
	    }

	    @Override
	    public BookingDetails addBookingDetails(BookingDetails bookingDetails) {
	        return bookingDetailsRepository.save(bookingDetails);
	    }

	    @Override
	    public BookingDetails updateBookingDetails(BookingDetails bookingDetails) {
	        return bookingDetailsRepository.save(bookingDetails);
	    }

	    @Override
	    public void deleteBookingDetails(int bookingId) {
	        bookingDetailsRepository.deleteById(bookingId);
	    }

		@Override
		public BookingPayload getBookingDetailById(int bookingId) {
			Optional<BookingDetails> optionalBooking=bookingDetailsRepository.findById(bookingId);
			if (optionalBooking.isEmpty()) {
				throw new ResourceNotFoundException("Booking Details Not Found with Id"+bookingId);
		
			}
			BookingDetails booking =optionalBooking.get();
			User user = userService.getUserById(booking.getUserId());
			Hotel  hotel=hotelService.getHotelById(booking.getHotelId());
			Room room=hotelService.getRoomDetailsById(booking.getRoomId());
			
			BookingPayload Payload=new BookingPayload();
			Payload.setHotelName(hotel.getHotelName());
			Payload.setRoomType(room.getRoomType());
			Payload.setUserName(user.getUserName());
			Payload.setEmail(user.getEmail());
			Payload.setMobile(user.getMobile());
			Payload.setCity(hotel.getCity());
			Payload.setAvgRatePerDay(hotel.getAvgRatePerDay());
			Payload.setPhone1(hotel.getPhone1());
			Payload.setNoOfAdults(booking.getNoOfAdults());
			Payload.setNoOfChildren(booking.getNoOfChildren());
			Payload.setAmount(booking.getAmount());
			return Payload;
			
		}
	}


