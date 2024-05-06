package com.abc.bookingdetailservice.service;

import java.util.List;

import com.abc.bookingdetailservice.entity.BookingDetails;
import com.abc.bookingdetailservice.model.BookingPayload;
import com.abc.bookingdetailservice.model.Hotel;
import com.abc.bookingdetailservice.model.Room;
import com.abc.bookingdetailservice.model.User;



public interface BookingDetailsService {
      List<BookingDetails> getAllBookingDetails();
     BookingDetails addBookingDetails(BookingDetails bookingDetails);
     BookingDetails updateBookingDetails(BookingDetails bookingDetails);
     void deleteBookingDetails(int bookingId);
     
   BookingPayload getBookingDetailById(int bookingId);
}