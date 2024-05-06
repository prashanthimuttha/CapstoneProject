package com.hotelroom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelroom.entity.Room;

public interface RoomDetailsRepository extends JpaRepository<Room, Integer> {

}
