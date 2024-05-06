package com.abc.bookingdetailservice.entity;

import java.util.Date;

import com.abc.bookingdetailservice.model.Hotel;
import com.abc.bookingdetailservice.model.Room;
import com.abc.bookingdetailservice.model.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Booking_tbl")
public class BookingDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "booking_id")
	private int bookingId;
	@Column(name = "hotel_id")
	@NotNull(message = "provide valid ID")
	private int hotelId;
	@Column(name = "room_id")
	@NotNull(message = "provide valid ID")
	private int roomId;
	@Column(name = "user_id")
	@NotNull(message = "provide valid ID")
	private int userId;
@FutureOrPresent(message="bookingFromDate must be in the present Or future")
	private String bookedFrom;
@FutureOrPresent(message="bookingFromDate must be in the present Or future")
	private String bookedTo;
@Positive(message="Positive numbers only valid")
	private int noOfAdults;
@Positive(message="Positive numbers only valid")
	private int noOfChildren;
@Positive(message="Positive numbers only valid")
	private String amount;
}