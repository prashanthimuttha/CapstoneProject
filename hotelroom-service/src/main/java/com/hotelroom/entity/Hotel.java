package com.hotelroom.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "HOTEL")
public class Hotel {

	@Id
	@Column(name = "hotel_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int hotelId;
	@NotBlank(message = "City is mandratory")
	private String city;

	@Column(name = "hotel_name")
	private String hotelName;
	@NotBlank(message = "Address is mandratory")
	private String address;

	private String description;

	@Column(name = "avg_rate_per_day")
	@Positive(message = "positive are only allowed")
	private double avgRatePerDay;
	@NotBlank(message = "Email is mandratory")
	private String email;
	@Pattern(regexp = "^[0-9}{10}", message = "Invalid number")
	@Column(name = "phone_1")
	private String phone1;
	@Pattern(regexp = "^[0-9}{10}", message = "Invalid number")
	@Column(name = "phone_2")
	private String phone2;
	@NotBlank(message = "Website is mandratory")
	private String website;
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.ALL)
	private List<Room> roomDetails;

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getAvgRatePerDay() {
		return avgRatePerDay;
	}

	public void setAvgRatePerDay(double avgRatePerDay) {
		this.avgRatePerDay = avgRatePerDay;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone1() {
		return phone1;
	}

	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public List<Room> getRoomDetails() {
		return roomDetails;
	}

	public void setRoomDetails(List<Room> roomDetails) {
		this.roomDetails = roomDetails;
	}

}
