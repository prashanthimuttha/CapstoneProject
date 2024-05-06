package com.abc.bookingdetailservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


public class Hotel {
	    
	    private int hotelId;
	    private String city;
	    private String hotelName;
	    private String address;
	    private String description;
	    private double avgRatePerDay;
	    private String email;
	    private String phone1;
	    private String phone2;
	    
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
	}

