package com.abc.bookingdetailservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.bookingdetailservice.entity.BookingDetails;



public interface BookingDetailRepository extends JpaRepository<BookingDetails,Integer>{
	
}
