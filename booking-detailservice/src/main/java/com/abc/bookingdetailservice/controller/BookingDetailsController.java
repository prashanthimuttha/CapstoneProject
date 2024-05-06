package com.abc.bookingdetailservice.controller;

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
import com.abc.bookingdetailservice.entity.BookingDetails;
import com.abc.bookingdetailservice.model.BookingPayload;
import com.abc.bookingdetailservice.model.Hotel;
import com.abc.bookingdetailservice.model.Room;
import com.abc.bookingdetailservice.model.User;
import com.abc.bookingdetailservice.service.BookingDetailsService;

@RestController
@RequestMapping("/booking")
public class BookingDetailsController {
    @Autowired
    private BookingDetailsService bookingDetailsService;

    @GetMapping("/all")
    public List<BookingDetails> getAllBookingDetails() {
        return bookingDetailsService.getAllBookingDetails();
    }

    @PostMapping("/add")
    public BookingDetails addBookingDetails(@RequestBody BookingDetails bookingDetails) {
        return bookingDetailsService.addBookingDetails(bookingDetails);
    }

    @PutMapping("/Id")
    public BookingDetails updateBookingDetails(@RequestBody BookingDetails bookingDetails) {
        return bookingDetailsService.updateBookingDetails(bookingDetails);
    }

   @DeleteMapping("/{bookingId}")
    public void deleteBookingDetails(@PathVariable int bookingId) {
        bookingDetailsService.deleteBookingDetails(bookingId);
   }
    @GetMapping("/{Id}")
    public  ResponseEntity<BookingPayload> getBookingDetailById(@PathVariable("Id")int bookingId) {
    	
    	return new ResponseEntity<BookingPayload>(bookingDetailsService.getBookingDetailById(bookingId),HttpStatus.OK);
    }
}

